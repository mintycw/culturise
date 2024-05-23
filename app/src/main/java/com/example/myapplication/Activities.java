package com.example.myapplication;

/**
 * This class represents an activity with its image, place, and address.
 */
public class Activities {

    /**
     * The image resource ID of the activity.
     */
    public int m_ActivityImage;

    /**
     * The name or description of the place where the activity takes place.
     */
    public String m_ActivityPlace;

    /**
     * The address of the place where the activity takes place.
     */
    public String m_ActivityAddress;

    /**
     * Constructs a new Activity object with the given parameters.
     *
     * @param activityImage   The resource ID of the activity image.
     * @param activityPlace   The name or description of the place where the activity takes place.
     * @param activityAddress The address of the place where the activity takes place.
     */
    public Activities(int activityImage, String activityPlace, String activityAddress) {
        this.m_ActivityImage = activityImage;
        this.m_ActivityPlace = activityPlace;
        this.m_ActivityAddress = activityAddress;
    }
}

