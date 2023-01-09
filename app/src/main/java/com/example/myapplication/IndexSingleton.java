package com.example.myapplication;

public final class IndexSingleton {
    private static IndexSingleton m_Instance;

    public static int m_CultureIndex;
    public static int m_CategoryIndex;
    public static String[] m_Category;

    private IndexSingleton() {
    }

    public static IndexSingleton getInstance() {
        if (m_Instance == null) {
            m_Instance = new IndexSingleton();
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
}
