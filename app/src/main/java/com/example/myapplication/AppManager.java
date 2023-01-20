package com.example.myapplication;

import android.content.Context;

public final class AppManager {
    private static AppManager m_Instance;

    public int m_CultureIndex;
    public int m_CategoryIndex;
    public String[] m_Category;

    public int[] m_Activity;
    public String[] m_ActivityPlace;
    public String[] m_ActivityAddress;

    private AppManager() {
    }

    public static AppManager getInstance() {
        if (m_Instance == null) {
            m_Instance = new AppManager();
        }
        return m_Instance;
    }

    public void setCultureIndex(int index) {
        m_CultureIndex = index;
    }

    public int returnCultureIndex() {
        return m_CultureIndex;
    }

    public void setCategoryIndex(int index) {
        m_CategoryIndex = index;
    }

    public int returnCategoryIndex() {
        return m_CategoryIndex;
    }

    public String[] returnCategory() {
        return m_Category;
    }

    public int[] returnActivity(Context context, int culture, int category) {
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
                                R.drawable.de_chinese_boot,
                                R.drawable.tai_wu,
                                R.drawable.shanghai_papa,
                                R.drawable.de_nieuwe_chinese_muur,
                                R.drawable.cate_dak,
                                R.drawable.san_san,
                                R.drawable.bapao_bobo,
                        };
                        m_ActivityPlace = context.getResources().getStringArray(R.array.china_restaurants);
                        m_ActivityAddress = context.getResources().getStringArray(R.array.china_restaurants_address);
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
                        m_ActivityAddress = context.getResources().getStringArray(R.array.china_supermarkets_address);
                        break;
                    case 2: //Stores
                        m_Activity = new int[]{
                                R.drawable.qq_bakery,
                                R.drawable.st_anny_bakery,
                                R.drawable.tok10_store,
                        };
                        m_ActivityPlace = context.getResources().getStringArray(R.array.china_stores);
                        m_ActivityAddress = context.getResources().getStringArray(R.array.china_stores_address);
                }
                break;
            case 1: //Italy
                switch (category) {
                    case 0: //Restaurant
                        m_Activity = new int[] {
                                R.drawable.ristorante_pizzeria_messina,
                                R.drawable.panzero_apulian_streat_food,
                                R.drawable.guliano,
                                R.drawable.oliva,
                                R.drawable.sugo_aert_van_nesstraat,
                                R.drawable.sugo_westblaak,
                                R.drawable.very_italian_pizza,
                                R.drawable.trattoria_a_proposito,
                                R.drawable.booon,
                        };
                        m_ActivityPlace = context.getResources().getStringArray(R.array.italy_restaurants);
                        m_ActivityAddress = context.getResources().getStringArray(R.array.italy_restaurants_address);
                        break;
                    case 1: //Supermarket
                        m_Activity = new int[] {
                                R.drawable.little_italy,
                                R.drawable.foodelicious_food_gifts,
                        };
                        m_ActivityPlace = context.getResources().getStringArray(R.array.italy_supermarkets);
                        m_ActivityAddress = context.getResources().getStringArray(R.array.italy_supermarkets_address);
                        break;
                    case 2: //Stores
                        m_Activity = new int[]{
                                R.drawable.coco_cheri,
                                R.drawable.la_zia_maria,
                                R.drawable.la_vita_e_bella_traiteur_bv,
                                R.drawable.magazijn_houtkamp_menkveld,
                        };
                        m_ActivityPlace = context.getResources().getStringArray(R.array.italy_stores);
                        m_ActivityAddress = context.getResources().getStringArray(R.array.italy_stores_address);
                        break;
                    case 3: //Wine
                        m_Activity = new int[]{
                                R.drawable.gusto_italiano,
                                R.drawable.franco_miscia,
                                R.drawable.dirck3,
                        };
                        m_ActivityPlace = context.getResources().getStringArray(R.array.italy_winestores);
                        m_ActivityAddress = context.getResources().getStringArray(R.array.italy_winestores_address);
                        break;
                }
                break;
            case 2: //Japan
                switch (category) {
                    case 0: //Restaurant
                        m_Activity = new int[] {
                                R.drawable.happy_mango,
                                R.drawable.itami,
                                R.drawable.sumo,
                                R.drawable.miso_sushi_plaza,
                                R.drawable.shabu_shabu,
                                R.drawable.iyumi,
                                R.drawable.shiki_sushi_lounge,
                                R.drawable.azura,
                                R.drawable.ajisan_authentic_tokyo_ramen,
                                R.drawable.tensai_ramen,
                                R.drawable.set_noodle_rotterdam,
                                R.drawable.hinoki,
                                R.drawable.ramen_bar_sensei,
                                R.drawable.shin_japanese_tapasbar_matcha_cafe,
                                R.drawable.jushi_cafe,
                                R.drawable.souffle_cafe,
                                R.drawable.restaurant_three,
                                R.drawable.umami_by_han,
                                R.drawable.kiiro_wijnhaven,
                                R.drawable.takumi_dusseldorf,
                        };
                        m_ActivityPlace = context.getResources().getStringArray(R.array.japan_restaurants);
                        m_ActivityAddress = context.getResources().getStringArray(R.array.japan_restaurants_address);
                        break;
                    case 1: //Supermarket
                        m_Activity = new int[] {
                                R.drawable.amazing_oriental_rotterdam_centrum,
                                R.drawable.amazing_oriental_parkhaven,
                                R.drawable.kazaguruma,
                        };
                        m_ActivityPlace = context.getResources().getStringArray(R.array.japan_supermarkets);
                        m_ActivityAddress = context.getResources().getStringArray(R.array.japan_supermarkets_address);
                        break;
                    case 2: //Stores
                        m_Activity = new int[]{
                                R.drawable.nishi,
                                R.drawable.osozai,
                                R.drawable.tok10_store,
                        };
                        m_ActivityPlace = context.getResources().getStringArray(R.array.japan_stores);
                        m_ActivityAddress = context.getResources().getStringArray(R.array.japan_stores_address);
                        break;
                }
                break;
            case 3: //Turkey
                switch (category) {
                    case 0: //Restaurant
                        m_Activity = new int[] {
                                R.drawable.ortam_bbq,
                                R.drawable.bazar,
                                R.drawable.dunya_lokanta,
                                R.drawable.ortam_bbq2,
                                R.drawable.ganii_kebap,
                                R.drawable.zela_restaurant,
                                R.drawable.fadi_s,
                                R.drawable.sofra_pide_noordplein,
                                R.drawable.hkiki,
                        };
                        m_ActivityPlace = context.getResources().getStringArray(R.array.turkey_restaurants);
                        m_ActivityAddress = context.getResources().getStringArray(R.array.turkey_restaurants_address);
                        break;
                    case 1: //Supermarket
                        m_Activity = new int[] {
                                R.drawable.ilham,
                                R.drawable.yasam,
                                R.drawable.aytas,
                                R.drawable.abi,
                                R.drawable.kbs,
                                R.drawable.sahan,
                        };
                        m_ActivityPlace = context.getResources().getStringArray(R.array.turkey_supermarkets);
                        m_ActivityAddress = context.getResources().getStringArray(R.array.turkey_supermarkets_address);
                        break;
                    case 2: //Stores
                        m_Activity = new int[] {
                                R.drawable.forbest,
                                R.drawable.liham,
                        };
                        m_ActivityPlace = context.getResources().getStringArray(R.array.turkey_stores);
                        m_ActivityAddress = context.getResources().getStringArray(R.array.turkey_stores_address);
                        break;
                    case 3: //Mosques
                        m_Activity = new int[] {
                                R.drawable.mevlana_moskee,
                                R.drawable.gultepe_moskee,
                                R.drawable.kocatepe_moskee,
                                R.drawable.iskender_pasa_camii,
                                R.drawable.essalam_moskee,
                        };
                        m_ActivityPlace = context.getResources().getStringArray(R.array.turkey_mosques);
                        m_ActivityAddress = context.getResources().getStringArray(R.array.turkey_mosques_address);
                        break;
                }
                break;
            case 4: //Spain
                switch (category) {
                    case 0: //Restaurant
                        m_Activity = new int[] {
                                R.drawable.lokanta_proeflokaal,
                                R.drawable.la_tapadera,
                                R.drawable.guay,
                                R.drawable.de_hemel_op_aarde,
                                R.drawable._1_pinchos_fenix,
                                R.drawable.bar_berta,
                                R.drawable.spaanse_poort,
                                R.drawable.destino,
                                R.drawable.la_cazuela,
                        };
                        m_ActivityPlace = context.getResources().getStringArray(R.array.spain_restaurants);
                        m_ActivityAddress = context.getResources().getStringArray(R.array.spain_restaurants_address);
                        break;
                    case 1: //Supermarket
                        m_Activity = new int[] {
                                R.drawable.iberica_la_espanola,
                        };
                        m_ActivityPlace = context.getResources().getStringArray(R.array.spain_supermarkets);
                        m_ActivityAddress = context.getResources().getStringArray(R.array.spain_supermarkets_address);
                        break;
                    case 2: //Courses
                        m_Activity = new int[]{
                                R.drawable.una_paloma_blanca,
                                R.drawable.el_abinco,
                                R.drawable.fuentes,
                                R.drawable.la_espanola,
                                R.drawable.el_sol,
                                R.drawable.que_oproveche,
                        };
                        m_ActivityPlace = context.getResources().getStringArray(R.array.spain_courses);
                        m_ActivityAddress = context.getResources().getStringArray(R.array.spain_courses_address);
                        break;
                }
                break;
        }
        return m_Activity;
    }

    public String[] returnActivityPlace() {
        return m_ActivityPlace;
    }

    public String[] returnActivityAddress() {
        return m_ActivityAddress;
    }
}
