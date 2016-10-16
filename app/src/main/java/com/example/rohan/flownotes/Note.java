package com.example.rohan.flownotes;

/**
 * Created by Abhishek on 10/16/16.
 */

public class Note {
    // title string missing
    private String message;
    private long noteId, dateCreatedMilli;
    private Category category;


    public enum Category{ LOW, MEDIUM, HIGH }

    public Note(String message, Category category) {
        this.message = message;
        this.category = category;
        this.noteId = 0;
        this.dateCreatedMilli = 0;

}

    public Note(String message, Category category, long noteId, long dateCreatedMilli) {
        this.message = message;
        this.category = category;
        this.noteId = noteId;
        this.dateCreatedMilli = dateCreatedMilli;

    }

    public String getMessage() {
        return message;
    }

    public Category getCategory() {
        return category;
    }

    public long getDate() {
        return dateCreatedMilli;
    }

    public long getId() {
        return noteId;
    }

    public String toString() {
        return "ID: " + noteId + "Message" + message + "IconID: " + category.name() + "Date: ";
    }


    public static int categoryToDrawable(Category noteCategory) {

        switch (noteCategory) {
            case LOW:
                return R.drawable.pl;
            case MEDIUM:
                return R.drawable.pm;
            case HIGH:
                return R.drawable.ph;

        }

        return R.drawable.pl;

    }

    public int getAssociatedDrawable() {
        return categoryToDrawable(category);
    }
}


