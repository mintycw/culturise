package com.example.myapplication;

/**
 * Represents a category with its text and image.
 */
public class Categories {

    /**
     * The text description of the category.
     */
    public String m_CategoryText;

    /**
     * The resource ID of the category image.
     */
    public int m_CategoryImage;

    /**
     * Constructs a new Categories object with the given text and image.
     *
     * @param categoryText  The text description of the category.
     * @param categoryImage The resource ID of the category image.
     */
    public Categories(String categoryText, int categoryImage) {
        this.m_CategoryText = categoryText;
        this.m_CategoryImage = categoryImage;
    }
}
