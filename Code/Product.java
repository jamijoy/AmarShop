// package Code.textLib;
import java.sql.*;	
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// import java.io.FileOutputStream;
// import java.io.IOException;
// import com.itextpdf.text.Document;
// import com.itextpdf.text.DocumentException;
// import com.itextpdf.text.Paragraph;
// import com.itextpdf.text.pdf.PdfWriter;

class Product extends JFrame implements ActionListener, MouseListener
{
	public String loginUser;
	private JPanel pn;
	public JButton logout, goBack, generate,preorder,genPDF;
	private JLabel s1, s2, uRole, uname, uID, genderLB, name, phone, balance,addressL, backImgLbl,bandImgLbl,orderNoLabel,userIDLabel,pIDLabel,pQuantityLabel;
	private JTextField orderNoTF,userIDTF,pIDTF,pQuantityTF;
	private JTable table;
	private JScrollPane scroll;
	private ImageIcon backImg,bandImg;
	private Color halkalal,ashColor;
	private Font s1font,btnfont;
	public String userID,userName,_name,gender,address,status;
	public int _phone;
	public double _balance;
	public int pID,pQuantity;
	public String pName,pCategory;
	public double pPrice;
	private Random r;
	
	public Product(int pID,int pQuantity,String pName,String pCategory,double pPrice,String userID,String userName,String _name,double _balance,String gender,int _phone,String address,String status)
	{
		loginUser=userName;
		this.userID=userID;
		this.userName=userName;
		this._name=_name;
		this._balance=_balance;
		this.gender=gender;
		this._phone=_phone;
		this.address=address;
		this.status=status;
		this.pID=pID;
		this.pQuantity=pQuantity;
		this.pName=pName;
		this.pCategory=pCategory;
		this.pPrice=pPrice;
		this.setTitle("Products from Amar Bazaar");
		this.setSize(1366,740);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pn = new JPanel();
		pn.setLayout(null);
		
		halkalal = new Color(167,37,37);
		ashColor = new Color(128,128,128);
		s1font = new Font("Impact",Font.BOLD,30);
		btnfont = new Font("Impact",Font.PLAIN,15);
		
		s1 = new JLabel("Welcome");
		s2 = new JLabel("Stored items of "+pCategory+"s");
		uRole = new JLabel("User Type : "+status);
		uname = new JLabel("your username is : "+userName);
		uID = new JLabel("Identity Number : "+userID);
		name  = new JLabel("Name : "+_name);
		balance = new JLabel("Current Balance : "+_balance);
		genderLB = new JLabel("Gender : "+gender);
		phone = new JLabel("Contact No : "+"0"+_phone);
		addressL = new JLabel("Address : "+address);
		orderNoLabel= new JLabel("order no:");
		userIDLabel= new JLabel("user id:");
		pIDLabel= new JLabel("Product ID:");
		pQuantityLabel= new JLabel("Product Quantity:");

		orderNoTF=new JTextField();
		userIDTF=new JTextField(userID);
		userIDTF.setEnabled(false);
		pIDTF=new JTextField();
		pQuantityTF=new JTextField();

		
		goBack = new JButton("Go Back");
		logout = new JButton("Logout ?");
		generate= new JButton("generate");
		preorder= new JButton("preorder");
		genPDF= new JButton("Generate PDF");

		
		backImg = new ImageIcon("back_img.jpg");
		backImgLbl = new JLabel(backImg);
		bandImg = new ImageIcon("side_bar.png");
		bandImgLbl = new JLabel(bandImg);
		
		s1.setBounds(985,150,200,30);
		s2.setBounds(250,250,400,30);
		uRole.setBounds(985,200,300,30);
		uname.setBounds(985,240,300,30);
		uID.setBounds(985,280,300,30);
		name.setBounds(985,320,300,30);
		balance.setBounds(985,360,300,30);
		genderLB.setBounds(985,400,300,30);
		phone.setBounds(985,440,300,30);
		addressL.setBounds(985,450,300,80);
		logout.setBounds(985,580,100,30);
		goBack.setBounds(1100,580,100,30);
		backImgLbl.setBounds(0,0,1366,740);
		bandImgLbl.setBounds(850,0,500,700);
		orderNoLabel.setBounds(300,520,100,30);
		userIDLabel.setBounds(400,520,100,30);
		pIDLabel.setBounds(500,520,100,30);
		pQuantityLabel.setBounds(600,520,100,30);
		orderNoTF.setBounds(300,550,100,30);
		userIDTF.setBounds(400,550,100,30);
		pIDTF.setBounds(500,550,100,30);
		pQuantityTF.setBounds(600,550,100,30);
		generate.setBounds(300,600,100,30);
		genPDF.setBounds(410,600,180,30);
		preorder.setBounds(600,600,100,30);
		
		s1.setForeground(halkalal);
		s1.setFont(s1font);
		s2.setFont(s1font);
		
		goBack.setFont(btnfont);
		logout.setFont(btnfont);
		
		setTable();	//set table to show product 
		
		generate.addActionListener(this);
		preorder.addActionListener(this);
		logout.addActionListener(this);
		goBack.addActionListener(this);
		
		// genPDF.btnPDFActionPerformed(this);

		generate.addMouseListener(this);
		preorder.addMouseListener(this);
		logout.addMouseListener(this);
		goBack.addMouseListener(this);
		
		pn.add(s1);
		pn.add(s2);
		pn.add(uname);
		pn.add(uID);
		pn.add(name);
		pn.add(phone);
		pn.add(uRole);
		pn.add(balance);
		pn.add(genderLB);
		pn.add(addressL);
		pn.add(logout);
		pn.add(goBack);
		pn.add(orderNoLabel);
		pn.add(userIDLabel);
		pn.add(pIDLabel);
		pn.add(pQuantityLabel);
		pn.add(orderNoTF);
		pn.add(userIDTF);
		pn.add(pIDTF);
		pn.add(pQuantityTF);
		pn.add(generate);
		pn.add(genPDF);
		pn.add(preorder);
		
		pn.add(bandImgLbl);
		pn.add(backImgLbl);
		
		this.add(pn);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("p_img.png")));
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String Text = ae.getActionCommand();
		
		if(Text.equals(logout.getText()))
		{
			LoginPG lp = new LoginPG();
			lp.setVisible(true);
			this.setVisible(false);
		}
		else if(Text.equals(goBack.getText()))
		{
			ckStatus(loginUser);
			this.setVisible(false);
		}
		else if(Text.equals(generate.getText()))
		{
			//create random number for order id
			r=new Random();
			int x=r.nextInt(100000000);	//random number range 0 to 99999999
			orderNoTF.setText(Integer.toString(x));
		}
		else if(Text.equals(preorder.getText()))
		{
			preorder();	//preoder products
		}
		
	}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseClicked(MouseEvent me){}
	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource() == logout)
		{
			logout.setBackground(ashColor);
			logout.setForeground(Color.WHITE);
		}
		if(me.getSource() == goBack)
		{
			goBack.setBackground(ashColor);
			goBack.setForeground(Color.WHITE);
		}
		if(me.getSource() == generate)
		{
			generate.setBackground(ashColor);
			generate.setForeground(Color.WHITE);
		}
		if(me.getSource() == preorder)
		{
			preorder.setBackground(ashColor);
			preorder.setForeground(Color.WHITE);
		}
		else
		{
		}
	}
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource() == logout)
		{
			logout.setBackground(Color.white);
			logout.setForeground(Color.black);
		}
		if(me.getSource() == preorder)
		{
			preorder.setBackground(Color.white);
			preorder.setForeground(Color.black);
		}
		if(me.getSource() == generate)
		{
			generate.setBackground(Color.white);
			generate.setForeground(Color.black);
		}
		if(me.getSource() == goBack)
		{
			goBack.setBackground(Color.white);
			goBack.setForeground(Color.black);
		}
		else
		{
		}
	}	

	public void preorder()
	{
		String orderID = orderNoTF.getText();
		String userID= userIDTF.getText();
		String productID = pIDTF.getText();
		String pQuantity = pQuantityTF.getText();
		int quantityTest = Integer.parseInt(pQuantity);
		double userBalance=0.00;
		int productQuantity=0;
		int orderQuantity=0;
		double productPrice=0.00;
		double orderPrice=0.00;

		try
		{	Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b25", "root", "");
			Statement stm = con.createStatement();
			ResultSet rs = null;
			if(quantityTest<0)
			{
				throw new NumberFormatException("Quantity can't be a negetive number");
			}
			else
			{
				pQuantity = pQuantityTF.getText();
			}
			String query1 = "INSERT INTO order_table VALUES ('"+orderID+"','"+userID+"','"+productID+"','"+pQuantity+"');";
			String query2 = "SELECT balance FROM user_accounts WHERE userID = '"+userID+"';";
			String query3 = "SELECT  `pQuantity`, `pPrice` FROM `product_details` WHERE `pID`='"+productID+"';"; 
			
			rs = stm.executeQuery(query3);

			while(rs.next())
			{
				productQuantity=rs.getInt("pQuantity");
				productPrice=rs.getDouble("pPrice");
			}
			rs = stm.executeQuery(query2);
			while(rs.next())
			{
				userBalance=rs.getDouble("balance");
			}
			orderQuantity=Integer.parseInt(pQuantity);
			orderPrice=productPrice*orderQuantity;
			if(productQuantity>=orderQuantity)
			{
				if(userBalance>=orderPrice)
				{
					stm.execute(query1);
				}
				else
				{
					throw new NumberFormatException("Not enough balance");
				}
			}
			else
			{
				throw new NumberFormatException("Not enough Product");
			}
			stm.close();
			con.close();
			JOptionPane.showMessageDialog(this, "successfully preordered");
			orderNoTF.setText("");
			pIDTF.setText("");
			pQuantityTF.setText("");
		}
		catch(NumberFormatException ex)
		{
			JOptionPane.showMessageDialog(this, ex.getMessage()+" ");
			System.out.println(ex.getMessage());
        }
        catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this, "preordered Error");
			System.out.println(ex.getMessage());
        }
	}	

	public void ckStatus(String loginUser)	 						//status check method
	{
		this.loginUser=loginUser;
		String query="SELECT `userID`, `userName`, `name`, `password`, `balance`, `gender`, `phone`, `address`, `status` FROM `user_accounts`;";
        Connection con=null;
        Statement st = null;
		ResultSet rs = null;
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b25","root","");
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			boolean flag = false;		
			while(rs.next())
			{
				flag = true;
                String userName = rs.getString("userName");
				String status = rs.getString("status");

				String userID=rs.getString("userID");
				String name=rs.getString("name");
				double balance=rs.getDouble("balance");
				String gender=rs.getString("gender");
				int phone=rs.getInt("phone");
				String address=rs.getString("address");
				if(userName.equals(loginUser))
				{
					flag=true;
					if(status.equals("Seller"))
					{
						HomePG pg = new HomePG(userID,userName,name,balance,gender,phone,address,status);
						pg.setVisible(true);
						this.setVisible(false);
						break;
					}
					else if(status.equals("Customer"))
					{
						HomePG pg = new HomePG(userID,userName,name,balance,gender,phone,address,status);
						pg.updateProduct.setVisible(false);
						pg.ordered.setVisible(false);
						pg.setVisible(true);
						this.setVisible(false);
						break;
					}
					else if(status.equals("Admin"))
					{
						HomePG pg = new HomePG(userID,userName,name,balance,gender,phone,address,status);
						pg.setVisible(true);
						this.setVisible(false);
						break;
					}
				}
			}
				
			if(!flag)
			{
				JOptionPane.showMessageDialog(this,"Invalid Credential");
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
        finally
		{
            try
			{
                if(rs!=null)
                {
					rs.close();
                }
                if(st!=null)
                {
					st.close();
                }
                if(con!=null)
                {
					con.close();
                }
            }
            catch(Exception ex){}
        }
	}
	// public void btnPDFActionPerformed(ActionEvent ae)
	// {
		// String path = "";
		// JFileChooser jc = new JFileChooser();
		// jc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		// int x = jc.showSaveDialog(this);
		
		// if(x==JFileChooser.APPROVE_OPTION)
		// {
			// path = jc.getSelectedFile().getPath();
		// }
		// Document doc = new Document();
		
		// try
		// {
		 	// PdfWriter.getInstance(doc, new FileOutputStream(path+"amarBazaar.pdf"));
			// doc.open();
			// PdfTable tbl = new PdfTable(3);
		
			// tbl.addCell("Transection Token");
			// tbl.addCell("Customer ID");
			// tbl.addCell("Prodect Quantity");
			
			// doc.add(tbl);
			// JOptionPane.showMessageDialog(null,"Downloaded PDF file", "ALERT MESSAGE", JOptionPane.WARNING_MESSAGE);
		// }		
		// catch(FileNotFoundException ex)
		// {
			// Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
		// }
		// catch(DocumentException ex)
		// {
			// Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
		// }
		// doc.close();
	// }
	public void setTable()	//table for show products
	{
		String query = "SELECT * FROM product_details WHERE pCategory='"+pCategory+"'";
        Connection con=null;
        Statement st = null;
		ResultSet rs = null;
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b25","root","");
			st = con.createStatement();
			rs = st.executeQuery(query);

			ResultSetMetaData rsmd=rs.getMetaData();	//ResultSetMetaData is a interface that collect all info of ResultSet object
			int c=rsmd.getColumnCount();	//getColumnCount return column number of a table
			Vector column=new Vector(c);	//Vector
			for(int i=1;i<=c;i++)
			{
				column.add(rsmd.getColumnName(i));	//getColumnName get column name of ResultSet object
			}
			Vector data=new Vector();	
			Vector row=new Vector();
			while(rs.next())
			{
				row=new Vector(c);	//Vector(c) column count c
				for(int i=1;i<=c;i++)
				{
					row.add(rs.getString(i));	//getString collect data of ResultSet object 
				}
				data.add(row);	//row's info add in data vector
			}
			table=new JTable(data,column);
			table.setEnabled(false);
			scroll=new JScrollPane(table);
			scroll.setBounds(250,300,600,150);
			pn.add(scroll);
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
        finally
		{
            try
			{
                if(rs!=null)
                {
					rs.close();
                }
                if(st!=null)
                {
					st.close();
                }
                if(con!=null)
                {
					con.close();
                }
            }
            catch(Exception ex){}
        }
	}
}