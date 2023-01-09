package com.example.myapplication;


import android.content.Context;

public final class AppManager {
    private static AppManager m_Instance;

    public static int m_CultureIndex;
    public static int m_CategoryIndex;
    public static String[] m_Category;

    public static int[] m_Activity;
    public static String[] m_ActivityPlace;
    public static String[] m_ActivityAdress;

    private AppManager() {
    }

    public static AppManager getInstance() {
        if (m_Instance == null) {
            m_Instance = new AppManager();
        }
        return m_Instance;
    }

    public static void setCultureIndex(int index) {
        m_CultureIndex = index;
    }

    public static int returnCultureIndex() {
        return m_CultureIndex;
    }

    public static void setCategoryIndex(int index) {
        m_CategoryIndex = index;
    }

    public static int returnCategoryIndex() {
        return m_CategoryIndex;
    }

    public static String[] returnCategory() {
        return m_Category;
    }

    public static int[] returnActivity(Context context, int culture, int category) {

        switch (culture) {
            case 0: //China
                switch (category) {
                    case 0: //Restaurant
                        m_Activity = new int[] {
                                R.drawable.meet_noodle,
                                R.drawable.restaurant_hong_kong,
                                R.drawable.chinatown_dim_sum,
                                R.drawable.ka_yin,
                                R.drawable.yuguo_hotpot_and_grill,
                                R.drawable.hot_and_hot,
                        };
                        m_ActivityPlace = context.getResources().getStringArray(R.array.china_restaurants);
                        m_ActivityAdress = context.getResources().getStringArray(R.array.china_restaurants_address);
                        break;
                    case 1: //Supermarket
                        m_Activity = new int[] {
                                R.drawable.may_fung_toko,
                                R.drawable.tokopoint,
                                R.drawable.amazing_oriental_rotterdam_centrum,
                                R.drawable.amazing_oriental_parkhaven,
                                R.drawable.wah_nam_hong,
                                R.drawable.wens,
                        };
                        m_ActivityPlace = context.getResources().getStringArray(R.array.china_supermarkets);
                        m_ActivityAdress = context.getResources().getStringArray(R.array.china_supermarket_address);
                        break;
                    case 2: //Stores
                        m_Activity = new int[]{
                                R.drawable.qq_bakery,
                                R.drawable.st_anny_bakery,
                                R.drawable.tok10_store,
                        };
                        m_ActivityPlace = context.getResources().getStringArray(R.array.china_stores);
                        m_ActivityAdress = context.getResources().getStringArray(R.array.china_stores_address);
                }
//            case 1: //Italy
        }
        return m_Activity;
    }

    public static String[] returnActivityPlace() {
        return m_ActivityPlace;
    }

    public static String[] returnActivityAddress() {
        return m_ActivityAdress;
    }
}
