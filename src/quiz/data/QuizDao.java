package quiz.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import quiz.entities.Question;
import quiz.entities.Quiz;

@Component
@Transactional
public class QuizDao {
	@PersistenceContext
	private EntityManager em;
	private List<String>listOfNames;
	private List<String>listOfAnswers;
	private List<String>listOfQuestions;
	
	
	public List<String> getListOfNames() {
		listOfNames = (List<String>)em.createQuery("SELECT q.name FROM Quiz q").getResultList();
		return listOfNames;
	}
	
	public List<String> getListOfAnswers(){
		listOfAnswers = (List<String>)em.createQuery("SELECT a.text FROM Answer a").getResultList();
		return listOfAnswers;
	}
	
	public List<String> getListOfQuestions(){
		listOfQuestions = (List<String>)em.createQuery("SELECT q.text FROM Question q").getResultList();
		return listOfQuestions;
	}
	
	public Quiz getListOfQuestionObjects(){
		Quiz q = (Quiz) em.createQuery("SELECT q FROM Quiz q WHERE q.id = 1").getSingleResult();

		return q;
	}
	
	public 


	public Quiz getQuiz(int id)
	{
		Quiz q = em.find(Quiz.class, id);
	
		return q;
	}
	
	public String getQuizName(int id) {
		Quiz q = em.find(Quiz.class, id);
		return q.getName();
	}
	
	public List<Question> getQuizQuestions(int id) {
		Quiz q = em.find(Quiz.class, id);
		return q.getQuestions();
		//build into controller and jsp
	}
	
	public void changeName(int id, String name) {
		Quiz q = em.find(Quiz.class, id);
		q.setName(name);
	}

}
