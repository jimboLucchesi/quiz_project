package quiz.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Question {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String text;

	@ManyToMany(mappedBy="questions")
	private List<Quiz> quizzes;
	
	@OneToMany(mappedBy="question")
	private List<Answer> answer;
	
	public List<Answer> getAnswer() {
		return answer;
	}
	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getId() {
		return id;
	}
	public List<Quiz> getQuizzes() {
		return quizzes;
	}
	public void setQuizzes(List<Quiz> quizzes) {
		this.quizzes = quizzes;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", text=" + text + ", quizzes=" + quizzes + ", answer=" + answer + "]";
	}
}
