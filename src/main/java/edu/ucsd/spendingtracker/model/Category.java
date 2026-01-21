package edu.ucsd.spendingtracker.model;

// Enum to manage categories and their associated UI colors
public enum Category {
    FOOD("#FFD1DC"),      // Pastel Pink
    TRANSPORT("#BCE29E"), // Pastel Green
    ENTERTAINMENT("#B3E5FC"), // Pastel Blue
    UTILITIES("#FFF9C4"), // Pastel Yellow
    OTHER("#E1BEE7");     // Pastel Purple

    public final String color;
    Category(String color) {
        this.color = color;
    }
}