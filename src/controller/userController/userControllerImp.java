package controller.userController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.accountDAO.accountDAO;
import controller.accountDAO.accountDAOImp;
import controller.addressDAO.addressDAOImp;
import controller.bookDAO.bookDAOImp;
import controller.bookitemDAO.bookitemDAOImp;
import controller.cartDAO.cartDAOImp;
import controller.customerDAO.customerDAOImp;
import controller.orderDAO.orderDAOImp;
import controller.paymentDAO.paymentDAO;
import controller.paymentDAO.paymentDAOImp;
import controller.shipmentDAO.shipmentDAOImp;
import mode.shipment.Shipment;
import model.book.Book;
import model.bookitem.Bookitem;
import model.cart.Cart;
import model.customer.Account;
import model.customer.Address;
import model.customer.Customer;
import model.order.Order;
import model.payment.Payment;


@WebServlet("/")
public class userControllerImp extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private boolean isLogin = false;
	private bookDAOImp bookdao;
	private accountDAOImp accountdao;
	private addressDAOImp addressdao;
	private customerDAOImp customerdao;
	private bookitemDAOImp bookitemdao;
	private cartDAOImp cartdao;
	private paymentDAOImp pmdao;
	private shipmentDAOImp smdao;
	private orderDAOImp orderdao;
	private int cusID;
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	public void init() {
        this.isLogin = isLogin;
        this.cusID = cusID;
        
    }
	
    public userControllerImp() {
    	
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();

        try {
            switch (action) {
                case "/register":
                    register(request, response);
                    break;
                case "/logout":
                    logout(request, response);
                    break;
                case "/show":
                    listBooks(request, response);
                    break;
                case "/addbook":
                    addBookItem(request, response);
                    break;
                case "/cart":
                    showCart(request, response);
                    break;
                case "/selectsp":
                    selectShipPayment(request, response);
                    break;
                case "/order":
                    showOrder(request, response);
                    break;
                case "/home":
                	login(request, response);
                	break;
                default:
                	listBooks(request, response);
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

    public void registerform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.sendRedirect("register.jsp");
    }

	public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO - implement userControllerImp.createAccount
		String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String age = request.getParameter("age");
        String phoneNum = request.getParameter("phoneNum");
        String email = request.getParameter("email");
        String accountNum = request.getParameter("accountNum");
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        String houseNo = request.getParameter("houseNo");
        
        accountdao = new accountDAOImp();
        addressdao = new addressDAOImp();
        customerdao = new customerDAOImp();
        cartdao = new cartDAOImp(); 
        
        System.out.print(password);
        Account acc = new Account(1, username, password);
        Address add = new Address(1, city, district, Integer.parseInt(houseNo));
        Customer cus = new Customer(1, name, gender, Integer.parseInt(age), add, acc, phoneNum, email, accountNum);
        addressdao.insertAddress(add);
        accountdao.createAccount(acc);
        acc.setID(accountdao.getMaxID());
        add.setID(addressdao.getMaxID());
        cus.setAccount(acc);
        cus.setAddress(add);
        customerdao.updateCustomer(cus);
        cus.setID(customerdao.getMaxID());
        Cart cart = new Cart(1, cus, 0, 0);
        cartdao.createCart(cart);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("registersuccess.jsp");
		dispatcher.forward(request, response);
	}

	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.isLogin = false;
//		System.out.print("CC");
		RequestDispatcher dispatcher = request.getRequestDispatcher("logout.jsp");
		dispatcher.forward(request, response);
	}

	public void listBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(this.isLogin == false){
			response.sendRedirect("login.jsp");
		}
		else{
			bookdao = new bookDAOImp();
			List<Book> listBook = bookdao.findAllBook();
//			System.out.print(listBook);s
	        request.setAttribute("listBook", listBook);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("booklist.jsp");
	        dispatcher.forward(request, response);
		}	
	}

	public void addBookItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
        int numbers= Integer.parseInt(request.getParameter("numbers"));
        System.out.print(id);
        System.out.print(numbers);
        bookitemdao = new bookitemDAOImp();
        bookdao = new bookDAOImp();
        cartdao = new cartDAOImp();
        int cartID = cartdao.findCart(this.cusID).getID();
        if(bookitemdao.checkItem(cartID, id)){
        	numbers = numbers + bookitemdao.getNum(cartID, id);
        	Bookitem bki = new Bookitem(1, bookdao.findByID(id), cartdao.findCart(this.cusID), numbers, 0);
        	bookitemdao.updateBookItem(bki, numbers);
        }
        else{
        	Bookitem bki = new Bookitem(1, bookdao.findByID(id), cartdao.findCart(this.cusID), numbers, 0);
        	bookitemdao.insertBookItem(bki);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/show");
		dispatcher.forward(request, response);
	}

	public void showCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bookitemdao = new bookitemDAOImp();
		cartdao = new cartDAOImp();
		List<Bookitem> listBook = bookitemdao.findAllBookitem(this.cusID);
		float cartPrice = 0;
		for(Bookitem b1 : listBook){
			cartPrice = cartPrice + b1.getTotalPrice();
		}
		cartdao.updateCart(cartdao.findCart(this.cusID), cartPrice);
//		System.out.print(listBook);
        request.setAttribute("listBook", listBook);
        request.setAttribute("cartPrice", cartPrice);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
        dispatcher.forward(request, response);
	}

	public void selectShipPayment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pmdao = new paymentDAOImp();
		smdao = new shipmentDAOImp();
		List<Payment> listPayment = pmdao.findAllPayment();
		List<Shipment> listShipment = smdao.findAllShipment();
		request.setAttribute("listPayment", listPayment);
        request.setAttribute("listShipment", listShipment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("payShip.jsp");
        dispatcher.forward(request, response);
	}

	public void showOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int paymentID = Integer.parseInt(request.getParameter("payment"));
        int shipmentID = Integer.parseInt(request.getParameter("shipment"));
        customerdao = new customerDAOImp();
        cartdao = new cartDAOImp();
        bookitemdao = new bookitemDAOImp();
        Customer customer = customerdao.viewCustomer(this.cusID);
        Cart cart = cartdao.findCart(this.cusID);
        Shipment shipment = smdao.selectShipment(shipmentID);
        Payment payment = pmdao.selectPayment(paymentID);
        orderdao = new orderDAOImp();
		Order order = new Order(1, customer, cart, shipment, payment, 0, 0, "0");
		orderdao.insertOrder(order);
		int orderID = orderdao.getMaxID();
		Order myOrder = orderdao.getOrder(orderID);
		bookitemdao = new bookitemDAOImp();
		List<Bookitem> listBook = bookitemdao.findAllBookitem(this.cusID);
		request.setAttribute("myOrder", myOrder);
		request.setAttribute("listBook", listBook);
		bookitemdao.deleteBookitem(cartdao.findCart(this.cusID).getID());
		RequestDispatcher dispatcher = request.getRequestDispatcher("order.jsp");
        dispatcher.forward(request, response);
	}

	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        accountdao = new accountDAOImp();
        customerdao = new customerDAOImp();
        
        if (accountdao.validateAccount(username, password)) {
        	this.isLogin = true;
        	this.cusID = customerdao.getCusID(accountdao.getAccID(username, password));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/show");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("loginfailed.jsp");
		}
	}

	public void loginform(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.sendRedirect("login.jsp");
	}

}