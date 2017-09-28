package application.database;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * The persistent class for the host_review database table.
 *
 */
@Entity
@Table(name="host_review")
@NamedQuery(name="HostReview.findAll", query="SELECT h FROM HostReview h")
public class HostReview implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="review_id")
	private int reviewId;

	private String content;

	private String from_username;

	@ManyToOne
	@JoinColumn(name="book_id")
	private BookInfo bookInfo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date time;

	private double rating;



	//bi-directional many-to-one association to BookInfo
	public HostReview() {
	}

	public int getReviewId() {
		return this.reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}



	public String getContent() {
		return content;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFrom_username() {
		return from_username;
	}

	public void setFrom_username(String from_username) {
		this.from_username = from_username;
	}

	public BookInfo getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}


	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
}
