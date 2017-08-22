package application.database;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the apartment database table.
 *
 */
@Entity
@Table(name="apartment")
@NamedQuery(name="Apartment.findAll", query="SELECT a FROM Apartment a")
public class Apartment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="apartment_id")
	private int apartmentId;

	private boolean aircondition;

	private BigDecimal area;

	private short baths;

	private short bed;

	@Column(name="clean_price")
	private BigDecimal cleanPrice;

	private boolean events;

	private boolean garage;

	private boolean heat;

	@Column(name="house_description")
	private String houseDescription;

	private boolean kitchen;

	private BigDecimal lat;

	@Column(name="leaving_room")
	private boolean leavingRoom;

	private boolean lift;

	private String location;

	private BigDecimal lon;

	@Column(name="max_people")
	private short maxPeople;

	@Column(name="min_people")
	private short minPeople;

	private String name;

	private boolean parking;

	private boolean pets;

	@Column(name="plus_price")
	private short plusPrice;

	private short price ;

	private short rooms;

	private String rules;

	private boolean smoking;

	@Column(name="standard_people")
	private short standardPeople;

	@Column(name="trasnportation_description")
	private String trasnportationDescription;

	private boolean tv;

	private String type;

	@Column(name="`wi-fi`")
	private boolean wi_fi;

	//bi-directional many-to-one association to HostInfo
	@ManyToOne
	@JoinColumn(name="host_info_login_username")
	private HostInfo hostInfo;

	//bi-directional many-to-one association to BookInfo
	@OneToMany(mappedBy="apartmentBean")
	private List<BookInfo> bookInfos;

	//bi-directional many-to-one association to BookReview
	@OneToMany(mappedBy="apartment")
	private List<BookReview> bookReviews;

	//bi-directional many-to-one association to Chat
	@OneToMany(mappedBy="apartment")
	private List<Chat> chats;

	public Apartment() {
	}

	public int getApartmentId() {
		return this.apartmentId;
	}

	public void setApartmentId(int apartmentId) {
		this.apartmentId = apartmentId;
	}

	public boolean getAircondition() {
		return this.aircondition;
	}

	public void setAircondition(boolean aircondition) {
		this.aircondition = aircondition;
	}

	public BigDecimal getArea() {
		return this.area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public short getBaths() {
		return this.baths;
	}

	public void setBaths(short baths) {
		this.baths = baths;
	}

	public short getBed() {
		return this.bed;
	}

	public void setBed(short bed) {
		this.bed = bed;
	}

	public BigDecimal getCleanPrice() {
		return this.cleanPrice;
	}

	public void setCleanPrice(BigDecimal cleanPrice) {
		this.cleanPrice = cleanPrice;
	}

	public boolean getEvents() {
		return this.events;
	}

	public void setEvents(boolean events) {
		this.events = events;
	}

	public boolean getGarage() {
		return this.garage;
	}

	public void setGarage(boolean garage) {
		this.garage = garage;
	}

	public boolean getHeat() {
		return this.heat;
	}

	public void setHeat(boolean heat) {
		this.heat = heat;
	}

	public String getHouseDescription() {
		return this.houseDescription;
	}

	public void setHouseDescription(String houseDescription) {
		this.houseDescription = houseDescription;
	}

	public boolean getKitchen() {
		return this.kitchen;
	}

	public void setKitchen(boolean kitchen) {
		this.kitchen = kitchen;
	}

	public BigDecimal getLat() {
		return this.lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public boolean getLeavingRoom() {
		return this.leavingRoom;
	}

	public void setLeavingRoom(boolean leavingRoom) {
		this.leavingRoom = leavingRoom;
	}

	public boolean getLift() {
		return this.lift;
	}

	public void setLift(boolean lift) {
		this.lift = lift;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public BigDecimal getLon() {
		return this.lon;
	}

	public void setLon(BigDecimal lon) {
		this.lon = lon;
	}

	public short getMaxPeople() {
		return this.maxPeople;
	}

	public void setMaxPeople(short maxPeople) {
		this.maxPeople = maxPeople;
	}

	public short getMinPeople() {
		return this.minPeople;
	}

	public void setMinPeople(short minPeople) {
		this.minPeople = minPeople;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getParking() {
		return this.parking;
	}

	public void setParking(boolean parking) {
		this.parking = parking;
	}

	public boolean getPets() {
		return this.pets;
	}

	public void setPets(boolean pets) {
		this.pets = pets;
	}

	public short getPlusPrice() {
		return this.plusPrice;
	}

	public void setPlusPrice(short plusPrice) {
		this.plusPrice = plusPrice;
	}

	public short getPrice() {
		return this.price;
	}

	public void setPrice(short price) {
		this.price = price;
	}

	public short getRooms() {
		return this.rooms;
	}

	public void setRooms(short rooms) {
		this.rooms = rooms;
	}

	public String getRules() {
		return this.rules;
	}

	public void setRules(String rules) {
		this.rules = rules;
	}

	public boolean getSmoking() {
		return this.smoking;
	}

	public void setSmoking(boolean smoking) {
		this.smoking = smoking;
	}

	public short getStandardPeople() {
		return this.standardPeople;
	}

	public void setStandardPeople(short standardPeople) {
		this.standardPeople = standardPeople;
	}

	public String getTrasnportationDescription() {
		return this.trasnportationDescription;
	}

	public void setTrasnportationDescription(String trasnportationDescription) {
		this.trasnportationDescription = trasnportationDescription;
	}

	public boolean getTv() {
		return this.tv;
	}

	public void setTv(boolean tv) {
		this.tv = tv;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean getWi_fi() {
		return this.wi_fi;
	}

	public void setWi_fi(boolean wi_fi) {
		this.wi_fi = wi_fi;
	}

	public HostInfo getHostInfo() {
		return this.hostInfo;
	}

	public void setHostInfo(HostInfo hostInfo) {
		this.hostInfo = hostInfo;
	}

	public List<BookInfo> getBookInfos() {
		return this.bookInfos;
	}

	public void setBookInfos(List<BookInfo> bookInfos) {
		this.bookInfos = bookInfos;
	}

	public BookInfo addBookInfo(BookInfo bookInfo) {
		getBookInfos().add(bookInfo);
		bookInfo.setApartmentBean(this);

		return bookInfo;
	}

	public BookInfo removeBookInfo(BookInfo bookInfo) {
		getBookInfos().remove(bookInfo);
		bookInfo.setApartmentBean(null);

		return bookInfo;
	}

	public List<BookReview> getBookReviews() {
		return this.bookReviews;
	}

	public void setBookReviews(List<BookReview> bookReviews) {
		this.bookReviews = bookReviews;
	}

	public BookReview addBookReview(BookReview bookReview) {
		getBookReviews().add(bookReview);
		bookReview.setApartment(this);

		return bookReview;
	}

	public BookReview removeBookReview(BookReview bookReview) {
		getBookReviews().remove(bookReview);
		bookReview.setApartment(null);

		return bookReview;
	}

	public List<Chat> getChats() {
		return this.chats;
	}

	public void setChats(List<Chat> chats) {
		this.chats = chats;
	}

	public Chat addChat(Chat chat) {
		getChats().add(chat);
		chat.setApartment(this);

		return chat;
	}

	public Chat removeChat(Chat chat) {
		getChats().remove(chat);
		chat.setApartment(null);

		return chat;
	}

}
