/*
--------------------
MySQL_Handler 클래스
--------------------
void connectDB() : db랑 연결합니다.
ArrayList<Integer> coffee_O() : 커피 id 리스트를 만듭니다.
ArrayList<Integer> coffee_X() : 논커피 id 리스트를 만듭니다.
ArrayList<Integer> allmenu() : 모든 메뉴의 id 리스트를 만듭니다.
ArrayList<Integer> brand_...() : 각 브랜드 메뉴의 id 리스트를 만듭니다.
String getMenuString(int i, String COLUMN) : String 값을 가져옵니다.(i: id값 / COLUMN 값: BRAND,NAME,PRICE,COFFEE)
ImageIcon getMenuImage(int i) : ImageIcon(메뉴이미지)을 가져옵니다. (i: id값)

이 코드는 sql의 수정, 삭제, 추가 등의 update 이후에도 유효합니다.

마지막 수정 날짜 : 2020-08-28  6:09 AM
수정 내용 : 논커피인 메뉴의 id가 저장되는 메소드 입력
           모든 메뉴의 id가 저장되는 메소드 입력
           각 브랜드 별 메뉴의 id가 저장되는 메소드 입력
           (+ 위 메소드가 작동하는데 필요한 모든 변수 입력)
 */

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;


public class MySQL_Handler {
    private ResultSet rs = null;
    private Statement st = null;
    private ImageIcon img = null;

    private int id = 1; //출력할 메뉴의 id값
    private static ArrayList<Integer> idList_coffee = new ArrayList<>();    //커피인 메뉴의 id가 저장될 arraylist
    private static ArrayList<Integer> idList_noncoffee = new ArrayList<>(); //논커피인 메뉴의 id가 저장될 arraylist
    private static ArrayList<Integer> idList_allmenu = new ArrayList<>();   //모든 메뉴의 id가 저장될 arraylist

    /* 각 브랜드 별 메뉴의 id가 저장될 arraylist */
    private static ArrayList<Integer> idList_brand_starbucks = new ArrayList<>();
    private static ArrayList<Integer> idList_brand_gongcha = new ArrayList<>();
    private static ArrayList<Integer> idList_brand_hollys = new ArrayList<>();
    private static ArrayList<Integer> idList_brand_paikdabang = new ArrayList<>();

    private String sql_O = "select * from cafemenu where coffee='O';";
    private String sql_X = "select * from cafemenu where coffee='X';";
    private String sql_all = "select * from cafemenu;";

    private String sql_brand_starbucks = "select * from cafemenu where brand='스타벅스';";
    private String sql_brand_gongcha = "select * from cafemenu where brand='공차';";
    private String sql_brand_hollys = "select * from cafemenu where brand='할리스커피';";
    private String sql_brand_paikdabang = "select * from cafemenu where brand='빽다방';";


    private void make_coffeeList(String sql_coffee){    //커피 또는 논커피의 id가 저장된 Arraylist 를 생성
        try{
            rs = st.executeQuery(sql_coffee);
            while(rs.next()){
                idList_coffee.add(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void make_noncoffeeList(String sql_noncoffee){    //커피 또는 논커피의 id가 저장된 Arraylist 를 생성
        try{
            rs = st.executeQuery(sql_noncoffee);
            while(rs.next()){
                idList_noncoffee.add(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void make_allmenuList(String sql_allmenu){    // 전체 메뉴의 id가 저장된 Arraylist 를 생성
        try{
            rs = st.executeQuery(sql_allmenu);

            while(rs.next()){
                idList_allmenu.add(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* 각 브랜드 별 메뉴의 id가 저장된 ArrayList 를 생성 */
    private void make_brandList_starbucks(String sql_brand_starbucks){
        try{
            rs = st.executeQuery(sql_brand_starbucks);
            while(rs.next()){
                idList_brand_starbucks.add(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void make_brandList_gongcha(String sql_brand_gongcha){
        try{
            rs = st.executeQuery(sql_brand_gongcha);
            while(rs.next()){
                idList_brand_gongcha.add(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void make_brandList_hollys(String sql_brand_hollys){
        try{
            rs = st.executeQuery(sql_brand_hollys);
            while(rs.next()){
                idList_brand_hollys.add(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void make_brandList_paikdabang(String sql_brand_paikdabang){
        try{
            rs = st.executeQuery(sql_brand_paikdabang);
            while(rs.next()){
                idList_brand_paikdabang.add(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void conectDB() {   //db에 연결하기
        Connection con = null;
        // url, id, password 연결은 각자의 mysql 로컬 호스트에 되어 있어야 한다
        String url = "jdbc:mysql://localhost:3306/dbdb?serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false";
        String id = "root";
        String password = "0709";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, id, password);
            System.out.println("DB 연결 완료");
            st = con.createStatement();
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 에러");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL 실행 에러");
            e.printStackTrace();
        }
    }


   //커피 id가 담긴 arraylist를 반환
    public ArrayList<Integer> coffee_O(){
        make_coffeeList(sql_O);
        return idList_coffee;
    }

    //논커피 id가 담긴 arraylist를 반환
    public ArrayList<Integer> coffee_X(){
        make_noncoffeeList(sql_X);
        return idList_noncoffee;
    }

    //모든 메뉴의 id가 담긴 arraylist를 반환
    public ArrayList<Integer> allmenu(){
        make_allmenuList(sql_all);
        return idList_allmenu;
    }

    /* 각 브랜드 별 메뉴의 id가 담긴 arraylist를 반환 */
    public ArrayList<Integer> brand_starbucks(){
        make_brandList_starbucks(sql_brand_starbucks);
        return idList_brand_starbucks;
    }
    public ArrayList<Integer> brand_gongcha(){
        make_brandList_gongcha(sql_brand_gongcha);
        return idList_brand_gongcha;
    }
    public ArrayList<Integer> brand_hollys(){
        make_brandList_hollys(sql_brand_hollys);
        return idList_brand_hollys;
    }
    public ArrayList<Integer> brand_paikdabang(){
        make_brandList_paikdabang(sql_brand_paikdabang);
        return idList_brand_paikdabang;
    }


    //id에 해당하는 필요한 값을 반환
    public String getMenuString(int i, String COLUMN) {
        String sql =  "select * from cafemenu where id='"+i+"';";
        String value = null;
        try {
            rs = st.executeQuery(sql);
            if (rs.next()) {
                switch (COLUMN) {
                    case "BRAND":
                        value = rs.getString("brand");
                        break;
                    case "NAME":
                        value = rs.getString("name");
                        break;
                    case "PRICE":
                        value = rs.getString("price");
                        break;
                    case "COFFEE":
                        value = rs.getString("coffee");
                        break;
                    default:
                        value = null;
                }
            }
        }catch (SQLException e){

        }
        return value;
    }
/*
    public ImageIcon getMenuImage(int i) {
        String sql =  "select * from cafemenu where id='"+i+"';";
        try {
            rs = st.executeQuery(sql);
            if (rs.next()) {
                Blob b = rs.getBlob("image");   //DB에서 바이너리 데이터 얻어옴
                img = new ImageIcon(b.getBytes(1, (int) b.length()));//바이너리 데이터를 이미지 포맷으로 변환
                }
        }catch (SQLException e){

        }
        return img;
    }
*/

    public ImageIcon getMenuImage(int i) {
        String sql =  "select * from cafemenu where id='"+i+"';";
        try {
            rs = st.executeQuery(sql);
            if (rs.next()) {
                Blob b = rs.getBlob("image");   //DB에서 바이너리 데이터 얻어옴
                img = new ImageIcon(b.getBytes(1, (int) b.length()));//바이너리 데이터를 이미지 포맷으로 변환
                Image temp = img.getImage();
                temp = temp.getScaledInstance(300,300, Image.SCALE_SMOOTH);
                img = new ImageIcon(temp);
            }
        }catch (SQLException e){

        }
        return img;
    }


}
