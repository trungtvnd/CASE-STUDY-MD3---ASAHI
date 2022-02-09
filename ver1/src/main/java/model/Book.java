package model;

public class Book {
    private int id;
    private String name;
    private String authorID;
    private String describe;
    private String language;
    private String status;
    private String type;
    private String publish;
    private String positionID;
    private String yearPublish;
    private String image;

    public Book(int id, String name, String describe, String language, String status, String type, String yearPublish, String image) {
        this.id = id;
        this.name = name;
        this.describe = describe;
        this.language = language;
        this.status = status;
        this.type = type;
        this.yearPublish = yearPublish;
        this.image = image;
    }

    public Book(String name, String describe, String language, String status, String type, String yearPublish, String image) {
        this.name = name;
        this.describe = describe;
        this.language = language;
        this.status = status;
        this.type = type;
        this.yearPublish = yearPublish;
        this.image = image;
    }

    public Book(String name, String authorID, String describe, String language, String status, String type, String publish, String positionID, String yearPublish, String image) {
        this.name = name;
        this.authorID = authorID;
        this.describe = describe;
        this.language = language;
        this.status = status;
        this.type = type;
        this.publish = publish;
        this.positionID = positionID;
        this.yearPublish = yearPublish;
        this.image = image;
    }

    public Book(int id, String name, String authorID, String describe, String language, String status, String type, String publish, String positionID, String yearPublish, String image) {
        this.id = id;
        this.name = name;
        this.authorID = authorID;
        this.describe = describe;
        this.language = language;
        this.status = status;
        this.type = type;
        this.publish = publish;
        this.positionID = positionID;
        this.yearPublish = yearPublish;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getPositionID() {
        return positionID;
    }

    public void setPositionID(String positionID) {
        this.positionID = positionID;
    }

    public String getYearPublish() {
        return yearPublish;
    }

    public void setYearPublish(String yearPublish) {
        this.yearPublish = yearPublish;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
