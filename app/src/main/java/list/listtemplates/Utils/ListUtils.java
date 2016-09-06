package list.listtemplates.Utils;

import android.content.Context;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import list.listtemplates.ExpandableParentDTO.ExpandableParentDTO;
import list.listtemplates.R;
import list.listtemplates.simplelistTypes.SimpleDTOType1;
import list.listtemplates.simplelistTypes.SimpleGridDTO;

/**
 * Created by CHANDRASAIMOHAN on 8/31/2016.
 */
public class ListUtils {

    public static List<SimpleDTOType1> getData(){
        List<SimpleDTOType1> dataList = new ArrayList<>();
        int[] images = {R.drawable.ic_india_64,R.drawable.ic_sl_64,R.drawable.ic_zim_64,
                R.drawable.ic_india_64,R.drawable.ic_aus_64,R.drawable.ic_india_64,
                R.drawable.ic_india_64,R.drawable.ic_sa_64,R.drawable.ic_sl_64,
                R.drawable.ic_india_64,R.drawable.ic_india_64,R.drawable.ic_india_64,
                R.drawable.ic_sa_64,R.drawable.ic_zim_64,R.drawable.ic_sl_64,
                R.drawable.ic_sa_64,R.drawable.ic_india_64,R.drawable.ic_sl_64,
                R.drawable.ic_india_64,R.drawable.ic_india_64,R.drawable.ic_india_64,
                R.drawable.ic_india_64,R.drawable.ic_sa_64,R.drawable.ic_sa_64,
                R.drawable.ic_india_64,R.drawable.ic_sa_64,
                R.drawable.ic_india_64,R.drawable.ic_sa_64,R.drawable.ic_aus_64,R.drawable.ic_sa_64,
                R.drawable.ic_india_64,R.drawable.ic_india_64,R.drawable.ic_sa_64,
                R.drawable.ic_sl_64,R.drawable.ic_india_64,R.drawable.ic_sa_64,
                R.drawable.ic_india_64,R.drawable.ic_india_64,R.drawable.ic_aus_64,
                R.drawable.ic_india_64,R.drawable.ic_india_64,R.drawable.ic_sl_64,
                R.drawable.ic_india_64,R.drawable.ic_sa_64,R.drawable.ic_aus_64,
                R.drawable.ic_sa_64,R.drawable.ic_india_64,R.drawable.ic_india_64,
                R.drawable.ic_sa_64,R.drawable.ic_sa_64,
                R.drawable.ic_india_64,R.drawable.ic_sa_64,R.drawable.ic_india_64,
                R.drawable.ic_india_64,R.drawable.ic_india_64,R.drawable.ic_india_64,
                R.drawable.ic_sa_64,R.drawable.ic_zim_64,R.drawable.ic_sl_64,
                R.drawable.ic_india_64,R.drawable.ic_sa_64,
                R.drawable.ic_india_64,R.drawable.ic_sa_64,
                R.drawable.ic_india_64,R.drawable.ic_sa_64,R.drawable.ic_aus_64,
                R.drawable.ic_sl_64,R.drawable.ic_sa_64,R.drawable.ic_sa_64,
                R.drawable.ic_india_64,R.drawable.ic_india_64,R.drawable.ic_zim_64,
                R.drawable.ic_aus_64,R.drawable.ic_zim_64,R.drawable.ic_india_64
        };

        String[] titles={"Azhar","ArvindDSilva","Aliastar",
                "BishenSinghBedi","Bevan","Badrinath",
                "CAPujara","Cronje","Chaminda",
                "Dhoni","Dravid","DKartik",
                "Elgar","Edwards","Ekanayake,B",
                "FAF","Fazal","FDM Karunaratne",
                "Gambhir","Ganguly","Gaekwad",
                "Harbhajan","HashimAmla","Hudson",
                "Ishant","Imran Tahir",
                "Jadeja","Jaques Kallis","J Faulkner","Jonty",
                "Kanitkar","KLRahul","KAbbott",
                "LD Chandimal","Lans Klusner","LalaAmarnadh",
                "MSDhoni","MskPrasad","MathewHayden",
                "NayanMongia","Navjyot Sidhu","NLTC Perera",
                "Ojha","Oakes JP","O Brien",
                "Pollock","Pandya","PraveenKumar",
                "QDCock","Qasim Khurshid",
                "RJadeja","Rabada","Rayudu",
                "Sachin","Shikar","Shami",
                "T Bavuma","T Mupariwa","TDilshan",
                "Unadket","Utseya P ",
                "Virat","VD Philander",
                "WP Saha","WD Parnell","Wade",
                "Xavier","Xosa","Xaba",
                "Yuvraj","Yusuf Patan","Young",
                "Zampa","Zambuko","Zaheer"
        };

        //   String[] titles  = {"India","Brazil","EEUU","Iran","Malaysia","NetherLands","Romania","Turkey","UK","Uzebkistan"};

        for(int i=0;i<titles.length && i<images.length;i++){
            SimpleDTOType1 temp = new SimpleDTOType1();
            temp.iconId = images[i];
            temp.title = titles[i];
            dataList.add(temp);

        }
        Collections.sort(dataList, new TitleComparator());
        return  dataList;
    }

    static class  TitleComparator implements Comparator {
        public int compare(Object o1,Object o2){
            SimpleDTOType1 s1=(SimpleDTOType1)o1;
            SimpleDTOType1 s2=(SimpleDTOType1)o2;

            return s1.title.compareTo(s2.title);
        }
    }


    public static List<SimpleDTOType1> getSimpleListData(){
        List<SimpleDTOType1> dataList = new ArrayList<>();
        int[] images = {R.drawable.ic_india_flag,R.drawable.ic_brazil_flag,R.drawable.ic_eeuu_flags,R.drawable.ic_iran_flag,
                R.drawable.ic_malaysia_flag,R.drawable.ic_netherlands_flag,R.drawable.ic_romania_flag,R.drawable.ic_turkey_flag,
                R.drawable.ic_united_kingdom_flag,R.drawable.ic_uzbekistan_flag};
        String[] titles  = {"India","Brazil","EEUU","Iran","Malaysia","NetherLands","Romania","Turkey","UK","Uzebkistan"};

        for(int i=0;i<titles.length && i<images.length;i++){
            SimpleDTOType1 temp = new SimpleDTOType1();
            temp.iconId = images[i];
            temp.title = titles[i];
            dataList.add(temp);

        }
        return  dataList;
    }



    public static List<SimpleGridDTO> getSimpleGridHorizontalData(){
        List<SimpleGridDTO> dataList = new ArrayList<>();
       /* int[] images = {R.drawable.ic_alpha,R.drawable.ic_beta,
                R.drawable.ic_cupcake,R.drawable.ic_donut,
                R.drawable.ic_eclair,R.drawable.ic_froyo,
                R.drawable.ic_gingerbread,R.drawable.ic_honey,
                R.drawable.ic_icecream_sandwich,R.drawable.ic_jelly_bean,
                R.drawable.ic_kit_kat,R.drawable.ic_lollipop,
                R.drawable.ic_marsh_mallow, R.drawable.ic_nougat};*/

        int[] images = {R.drawable.ic_alpha,R.drawable.ic_beta,
                R.drawable.ic_cup_cake,R.drawable.ic_donut,
                R.drawable.ic_eclair,R.drawable.ic_froyo,
                R.drawable.ic_ginger,R.drawable.ic_honey,
                R.drawable.ic_icecream,R.drawable.ic_jelly,
                R.drawable.ic_kit_kat,R.drawable.ic_lolli,
                R.drawable.ic_marsh, R.drawable.ic_nogout};
        String[] titles  = {"Alpha","Beta",
                "CupCake","Donut",
                "Eclair","Froyo",
                "GingerBread","HoneyComb",
                "Icecream Sandwich","Jelly Bean",
                "Kitkat","Lollipop",
                "Marsh Mallow",  "Nogout"};

        for(int i=0;i<titles.length && i<images.length;i++){
            SimpleGridDTO temp = new SimpleGridDTO();
            temp.setVersion_image_id(images[i]);
            temp.setAndroid_version(titles[i]);
            dataList.add(temp);

        }
        return  dataList;
    }



    public static List<Object> getHeterogeneousData(){
        List<Object> heterogenousList = new ArrayList<>();
        int[] images = {
                R.drawable.ic_india_flag,
                R.drawable.ic_brazil_flag,
                R.drawable.ic_eeuu_flags,
                R.drawable.ic_iran_flag};
        String[] titles  = {"India","Brazil","EEUU","Iran"};


        int[] images1 = {
                R.drawable.ic_cup_cake,R.drawable.ic_donut,
                R.drawable.ic_eclair,R.drawable.ic_froyo,
                R.drawable.ic_ginger,R.drawable.ic_honey,
                R.drawable.ic_icecream,R.drawable.ic_jelly,
        };
        String[] titles1  = {
                "CupCake","Donut",
                "Eclair","Froyo",
                "GingerBread","HoneyComb",
                "Icecream Sandwich","Jelly Bean",
        };

        for(int i=0;i<titles.length && i<images.length;i++) {
            SimpleDTOType1 temp = new SimpleDTOType1();
            temp.iconId = images[i];
            temp.title = titles[i];
            heterogenousList.add(temp);
        }

        for(int j=0;j<titles1.length && j<images1.length;j++){
            SimpleGridDTO temp2 = new SimpleGridDTO();
            temp2.setVersion_image_id(images1[j]);
            temp2.setAndroid_version(titles1[j]);
            heterogenousList.add(temp2);

        }


        return  heterogenousList;
    }




    public static List<Object> getHeterogeneousType2Data(){
        List<Object> heterogenousList = new ArrayList<>();
        List<SimpleDTOType1>  heteroData1List = getHeteroData1();
        List<SimpleGridDTO> heteroData2List = getHeteroData2();
        //  heterogenousList.add(heteroData1List);
        //  heterogenousList.add(heteroData2List);

        int data1Size = heteroData1List.size();
        int data2Size = heteroData2List.size();
        int maxSize = -1;

        if(data1Size>data2Size){
            maxSize = data1Size;
        }else if(data2Size>data1Size){
            maxSize = data2Size;

        }else if(data1Size==data2Size){
            maxSize = data1Size;
        }

        if(maxSize==data1Size){
            for(int i=0;i<data1Size;i++){
                heterogenousList.add(heteroData1List.get(i));
                if(i<heteroData2List.size()) {
                    heterogenousList.add(heteroData2List.get(i));
                }
            }

        }else if(maxSize==data2Size){
            for(int i=0;i<data2Size;i++){
                if(i<heteroData1List.size()) {
                    heterogenousList.add(heteroData1List.get(i));
                }
                heterogenousList.add(heteroData2List.get(i));

            }
        }else{
            for(int i=0;i<data1Size;i++){
                heterogenousList.add(heteroData1List.get(i));
                heterogenousList.add(heteroData2List.get(i));
            }
        }


        return  heterogenousList;
    }


    private static List<SimpleDTOType1> getHeteroData1(){
        List<SimpleDTOType1> dataList = new ArrayList<>();
        int[] images = {R.drawable.ic_india_flag,R.drawable.ic_brazil_flag,R.drawable.ic_eeuu_flags,R.drawable.ic_iran_flag,
                R.drawable.ic_malaysia_flag,R.drawable.ic_netherlands_flag,R.drawable.ic_romania_flag,R.drawable.ic_turkey_flag,
                R.drawable.ic_united_kingdom_flag,R.drawable.ic_uzbekistan_flag};
        String[] titles  = {"India","Brazil","EEUU","Iran","Malaysia","NetherLands","Romania","Turkey","UK","Uzebkistan"};

        for(int i=0;i<titles.length && i<images.length;i++){
            SimpleDTOType1 temp = new SimpleDTOType1();
            temp.iconId = images[i];
            temp.title = titles[i];
            dataList.add(temp);

        }
        return  dataList;
    }



    private static List<SimpleGridDTO> getHeteroData2(){
        List<SimpleGridDTO> dataList = new ArrayList<>();


        int[] images = {R.drawable.ic_alpha,R.drawable.ic_beta,
                R.drawable.ic_cup_cake,R.drawable.ic_donut,
                R.drawable.ic_eclair,R.drawable.ic_froyo,
                R.drawable.ic_ginger,R.drawable.ic_honey,
                R.drawable.ic_icecream,R.drawable.ic_jelly,
                R.drawable.ic_kit_kat,R.drawable.ic_lolli,
                R.drawable.ic_marsh, R.drawable.ic_nogout};
        String[] titles  = {"Alpha","Beta",
                "CupCake","Donut",
                "Eclair","Froyo",
                "GingerBread","HoneyComb",
                "Icecream Sandwich","Jelly Bean",
                "Kitkat","Lollipop",
                "Marsh Mallow",  "Nogout"};

        for(int i=0;i<titles.length && i<images.length;i++){
            SimpleGridDTO temp = new SimpleGridDTO();
            temp.setVersion_image_id(images[i]);
            temp.setAndroid_version(titles[i]);
            dataList.add(temp);

        }
        return  dataList;
    }




    public static List<Object> getSectionedHeterogeneousData(){
        List<Object> heterogenousList = new ArrayList<>();
        int[] images = {R.drawable.ic_msd_wc,R.drawable.ic_kapil,R.drawable.ic_ricky,R.drawable.ic_tunga};
        String[] titles  = {"MS Dhoni(IND)","Kapil Dev(IND)","RickyPonting(AUS)","Rana Tunga(SL)"};


        int[] images1 = {R.drawable.ic_msd,R.drawable.ic_mark,R.drawable.ic_gilly,R.drawable.ic_sanga};
        String[] titles1  = {"MS Dhoni(IND)",
                "Mark Boucher (RSA)",
                "GilChrist(AUS)",
                "Sangakarra(SL)"};
        heterogenousList.add("WorldCup Winning Captains");
        for(int i=0;i<titles.length && i<images.length;i++) {
            SimpleDTOType1 temp = new SimpleDTOType1();
            temp.iconId = images[i];
            temp.title = titles[i];
            heterogenousList.add(temp);
        }

        heterogenousList.add("Android Versions");

        int[] images2 = {
                R.drawable.ic_kit_kat,R.drawable.ic_lolli,
                R.drawable.ic_marsh, R.drawable.ic_nogout};
        String[] titles2  = {
                "Kitkat","Lollipop",
                "Marsh Mallow",  "Nogout"};
        for(int k=0;k<titles2.length && k<images2.length;k++){
            SimpleGridDTO temp3 = new SimpleGridDTO();
            temp3.setVersion_image_id(images2[k]);
            temp3.setAndroid_version(titles2[k]);
            heterogenousList.add(temp3);
        }

        //

        heterogenousList.add("Best Wicket Keepers");
        for(int j=0;j<titles1.length && j<images1.length;j++){
            SimpleDTOType1 temp2 = new SimpleDTOType1();
            temp2.iconId = images1[j];
            temp2.title = titles1[j];
            heterogenousList.add(temp2);

        }


        return  heterogenousList;
    }



    public static List<Object> getSectionedHomoogeneousData(){
        List<Object> homogenousList = new ArrayList<>();
        int[] images = {R.drawable.ic_msd_wc,R.drawable.ic_kapil,R.drawable.ic_ricky,R.drawable.ic_tunga};
        String[] titles  = {"MS Dhoni(IND)","Kapil Dev(IND)","RickyPonting(AUS)","Rana Tunga(SL)"};


        int[] images1 = {R.drawable.ic_msd,R.drawable.ic_mark,R.drawable.ic_gilly,R.drawable.ic_sanga};
        String[] titles1  = {"MS Dhoni(IND)",
                "Mark Boucher (RSA)",
                "GilChrist(AUS)",
                "Sangakarra(SL)"};
        homogenousList.add("WorldCup Winning Captains");
        for(int i=0;i<titles.length && i<images.length;i++) {
            SimpleDTOType1 temp = new SimpleDTOType1();
            temp.iconId = images[i];
            temp.title = titles[i];
            homogenousList.add(temp);
        }
        homogenousList.add("Best Wicket Keepers");
        for(int j=0;j<titles1.length && j<images1.length;j++){
            SimpleDTOType1 temp2 = new SimpleDTOType1();
            temp2.iconId = images1[j];
            temp2.title = titles1[j];
            homogenousList.add(temp2);

        }


        return  homogenousList;
    }




    public static List<ExpandableParentDTO> getExpandableRecyclerViewData(){
        List<ExpandableParentDTO> expandableParentDTOList = new ArrayList<>();
        List<Object> heterogenousList;

        //
        int[] images = {R.drawable.ic_msd_wc,R.drawable.ic_kapil,R.drawable.ic_ricky,R.drawable.ic_tunga};
        String[] titles  = {"MS Dhoni(IND)","Kapil Dev(IND)","RickyPonting(AUS)","Rana Tunga(SL)"};


        int[] images1 = {R.drawable.ic_msd,R.drawable.ic_mark,R.drawable.ic_gilly,R.drawable.ic_sanga};
        String[] titles1  = {"MS Dhoni(IND)",
                "Mark Boucher (RSA)",
                "GilChrist(AUS)",
                "Sangakarra(SL)"};

        //
        heterogenousList = new ArrayList<>();

        for(int i=0;i<titles.length && i<images.length;i++) {
            SimpleDTOType1 temp = new SimpleDTOType1();
            temp.iconId = images[i];
            temp.title = titles[i];
            heterogenousList.add(temp);
        }
        ExpandableParentDTO tempExpandableParentDTO = new ExpandableParentDTO("WorldCup Winning Captains",heterogenousList);
        expandableParentDTOList.add(tempExpandableParentDTO);

        heterogenousList = new ArrayList<>();
        for(int j=0;j<titles1.length && j<images1.length;j++){
            SimpleDTOType1 temp2 = new SimpleDTOType1();
            temp2.iconId = images1[j];
            temp2.title = titles1[j];
            heterogenousList.add(temp2);
        }

        ExpandableParentDTO tempExpandableParentDTO2 = new ExpandableParentDTO("Best Wicket Keepers",heterogenousList);
        expandableParentDTOList.add(tempExpandableParentDTO2);
        return  expandableParentDTOList;
    }


}
