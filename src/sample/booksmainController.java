package sample;

import com.jfoenix.controls.JFXTextField;
import static java.lang.Math.random;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


public class booksmainController implements Initializable {
    @FXML
    private AnchorPane ap;
    
    @FXML
    private void close(){
        System.exit(0);
    }
    @FXML
    private String ran(){
        int a;
        a=(int) (Math.random()*1000);
        String x;
        x = Integer.toString(a);
        return x;
    }
    
    @FXML
    private JFXTextField st;
    
    @FXML
    private JFXTextField nf;
    @FXML
    private JFXTextField ns;
     @FXML
    private JFXTextField sez;
    
    
    @FXML
    private JFXTextField af;
    
    @FXML
    private Label la;
    
    @FXML
    private DatePicker df;
        
    @FXML
    private TableView<bk> btl;
    
    @FXML
    private TableColumn<bk,String> nc;
    @FXML
    private TableColumn<bk,Integer> ic;
    
    @FXML
    private TableColumn<bk,String> avc;
    
    @FXML
    private TableColumn<bk,String> wc;
    
     @FXML
    private TableColumn<bk,String> ac;
     
      @FXML
    private TableColumn<bk,String> dc;
    
    private dbcon dcon;
    
    private ObservableList<bk> data;
        private ObservableList<bk> sear;

    
    private String qu="SELECT * FROM bookt";
    
    private double xis,yis;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
            this.dcon=new dbcon();

        ap.setOnMousePressed(e ->{
            xis=Main.getStg().getX()-e.getSceneX();
            yis=Main.getStg().getY()-e.getSceneY();
            ap.setCursor(Cursor.CLOSED_HAND);

        });
        ap.setOnMouseDragged(e ->{
            Main.getStg().setX(e.getSceneX()+xis);
            Main.getStg().setY(e.getSceneY()+yis);
        });
        ap.setOnMouseReleased(e->{
            ap.setCursor(Cursor.DEFAULT);
        });


    }
    
    @FXML
    private void loadt() throws SQLException{
        try{
            this.la.setText("loading...");
            Connection conn=dbcon.connect();
            this.data=FXCollections.observableArrayList();
            ResultSet res=conn.createStatement().executeQuery(qu);
            
            while (res.next()){
                this.data.add(new bk(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6)));
                
            }
            
            
        }catch(SQLException e){
            System.out.print(e);
        }
        this.ic.setCellValueFactory(new PropertyValueFactory<bk,Integer>("Id"));
        this.nc.setCellValueFactory(new PropertyValueFactory<bk,String>("Book"));
        this.ac.setCellValueFactory(new PropertyValueFactory<bk,String>("Author"));
        this.dc.setCellValueFactory(new PropertyValueFactory<bk,String>("Date"));
        this.avc.setCellValueFactory(new PropertyValueFactory<bk,String>("Available"));
        this.wc.setCellValueFactory(new PropertyValueFactory<bk,String>("With"));

        this.btl.setItems(null);
        this.btl.setItems(this.data);
            this.la.setText("");
    }
    
    @FXML
    private void addBook() throws SQLException{
        String sql="INSERT INTO bookt(id,name,author,date,av,wi) VALUES(?,?,?,?,?,?)";
        
        if (this.af.getText().isEmpty() | this.nf.getText().isEmpty() | this.df.getEditor().getText().isEmpty()){
            this.la.setText("please fill all the fields");
       
    }else{
            try{
            Connection conn=dbcon.connect();
            PreparedStatement stmt =conn.prepareStatement(sql);
            
            stmt.setString(1,ran());
            stmt.setString(2,this.nf.getText());
            stmt.setString(3,this.af.getText());
            stmt.setString(4,this.df.getEditor().getText());
            stmt.setString(5,"avialable");
            stmt.setString(6," ");
            stmt.execute();
            conn.close();
            this.nf.setText("");
            this.af.setText("");
            this.df.getEditor().setText("");
            this.la.setText("");
            
        }catch(SQLException e){
            System.out.print("dee"+e);
            
        }
                    
        }
    
    }
    private  String re="DELETE FROM bookt WHERE id = ?";

    @FXML
    private void remove() throws SQLException{
        bk bo = btl.getSelectionModel().getSelectedItem();
        Connection conn=dbcon.connect();
        PreparedStatement stmt =conn.prepareStatement(re);
        stmt.setString(1,bo.getId());
        stmt.execute();
        
    }
    
    
    private  String se="SELECT id,name,author,date,av,wi FROM bookt WHERE name = ?";
    private  String seq="UPDATE bookt SET   av=?,wi=? WHERE id=?";
    
    @FXML
    private void search(){
         try{
            this.la.setText("loading...");
            Connection conn=dbcon.connect();
            PreparedStatement stmt =conn.prepareStatement(se);
            stmt.setString(1,this.ns.getText());
            this.sear=FXCollections.observableArrayList();
            ResultSet res=stmt.executeQuery();
            
            while (res.next()){
                this.sear.add(new bk(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6)));
                
            }
            
            
        }catch(SQLException e){
            System.out.print(e);
        }
        
       this.ic.setCellValueFactory(new PropertyValueFactory<bk,Integer>("Id"));
        this.nc.setCellValueFactory(new PropertyValueFactory<bk,String>("Book"));
        this.ac.setCellValueFactory(new PropertyValueFactory<bk,String>("Author"));
        this.dc.setCellValueFactory(new PropertyValueFactory<bk,String>("Date"));
        this.avc.setCellValueFactory(new PropertyValueFactory<bk,String>("Available"));
        this.wc.setCellValueFactory(new PropertyValueFactory<bk,String>("With"));
        this.btl.setItems(null);
        this.btl.setItems(this.sear);
            this.la.setText("");
    }
    
    @FXML
    private void seize() throws SQLException{
        bk bo = btl.getSelectionModel().getSelectedItem();
        Connection conn=dbcon.connect();
        PreparedStatement stmt =conn.prepareStatement(seq);
        stmt.setString(1,this.st.getText());
        stmt.setString(2,this.sez.getText());
        stmt.setString(3,bo.getId());

        stmt.execute();
        this.st.setText("");
        this.sez.setText("");
    }
    
    
}