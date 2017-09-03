package application.services;

import application.database.*;
import application.database.repositories.ApartmentRepository;
import application.database.repositories.BookInfoRepository;
import application.database.repositories.BookReviewRepository;
import application.database.repositories.HostReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


public class ReviewService {

    @Autowired
    BookInfoRepository bookInfoRepository;

    @Autowired
    ApartmentRepository apartmentRepository;

    @Autowired
    BookReviewRepository bookReviewRepository;

    @Autowired
    HostReviewRepository hostReviewRepository;


    public void createBookReview(int bookId,String comment,short rating,int apartmentId) throws Exception{
        BookInfo book=bookInfoRepository.findOne(bookId);
        if(book==null){
            throw new Exception("There is not a book");
        }
        Apartment apartment=apartmentRepository.findOne(apartmentId);
        if(apartment==null){
            throw new Exception("The apartment does not exist");
        }
        if(book.getBookReviews().size()>0){
            throw new Exception("There is a review you can not do more");
        }
        BookReview newBookReview=new BookReview();
        newBookReview.setApartment(apartment);
        newBookReview.setBookInfo(book);
        newBookReview.setComment(comment);
        newBookReview.setRating(rating);
        Date date=new Date();
        newBookReview.setTime(date);
        bookReviewRepository.save(newBookReview);
    }

    public  void createHostReview(int bookId,String content,String username)throws Exception{
        HostReview hostReview=new HostReview();
        BookInfo book=bookInfoRepository.findOne(bookId);
        if(book==null){
            throw new Exception("The book does not exist");
        }
        if(book.getHostReviews().size()>0){
            throw new Exception("There is a review you can not do more");
        }
        Login login=book.getApartment().getLogin();
        hostReview.setBookInfo(book);
        hostReview.setContent(content);
        hostReview.setFrom_username(username);
        hostReview.setLogin(login);
        hostReviewRepository.save(hostReview);
    }

}