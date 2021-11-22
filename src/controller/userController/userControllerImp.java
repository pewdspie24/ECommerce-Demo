package controller.userController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.bookDAO.BookDAOImp;
import controller.bookDAO.BookItemDAOImp;
import controller.clothesDAO.ClothesDAO;
import controller.clothesDAO.ClothesDAOImp;
import controller.clothesDAO.ClothesItemDAOImp;
import controller.customerDAO.AccountDAOImp;
import controller.customerDAO.AddressDAOImp;
import controller.customerDAO.CustomerDAOImp;
import controller.customerDAO.FullnameDAOImp;
import controller.customerDAO.PhoneDAOImp;
import controller.eletronicDAO.ElectronicDAO;
import controller.eletronicDAO.ElectronicDAOImp;
import controller.eletronicDAO.ElectronicItemDAOImp;
import controller.eletronicDAO.ElectronicItemDAO;
import controller.orderDAO.CartDAOImp;
import controller.orderDAO.OrderDAOImp;
import controller.orderDAO.PaymentDAOImp;
import controller.orderDAO.ShipmentDAOImp;
import controller.shoesDAO.ShoesDAOImp;
import controller.shoesDAO.ShoesItemDAOImp;
import model.book.Book;
import model.book.BookItem;
import model.book.Comics;
import model.book.LightNovel;
import model.book.Magazine;
import model.clothes.ClothesItem;
import model.customer.Account;
import model.customer.Address;
import model.customer.Customer;
import model.customer.Fullname;
import model.customer.Phone;
import model.electronic.ElectronicItem;
import model.order.Cart;
import model.shoes.Boot;
import model.shoes.Sandal;
import model.shoes.ShoesItem;
import model.shoes.Sneaker;

@WebServlet("/")
public class userControllerImp extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private BookDAOImp bookDAO;
	private AccountDAOImp accountDAO;
	private AddressDAOImp addressDAO;
	private PhoneDAOImp phoneDAO;
	private FullnameDAOImp fullnameDAO;
	private CustomerDAOImp customerDAO;
	private BookItemDAOImp bookItemDAO;
	private ShoesItemDAOImp shoesItemDAO;
	private ElectronicItemDAOImp electronicItemDAO;
	private ClothesItemDAOImp clothesItemDAO;
	private CartDAOImp cartDAO;
	private PaymentDAOImp paymentDAO;
	private ShipmentDAOImp shipmentDAO;
	private OrderDAOImp orderDAO;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public void init() {
	}

	public userControllerImp() {
		bookDAO = new BookDAOImp();
		accountDAO = new AccountDAOImp();
		addressDAO = new AddressDAOImp();
		phoneDAO = new PhoneDAOImp();
		fullnameDAO = new FullnameDAOImp();
		customerDAO = new CustomerDAOImp();
		bookItemDAO = new BookItemDAOImp();
		clothesItemDAO = new ClothesItemDAOImp();
		electronicItemDAO = new ElectronicItemDAOImp();
		shoesItemDAO = new ShoesItemDAOImp();
		cartDAO = new CartDAOImp();
		paymentDAO = new PaymentDAOImp();
		shipmentDAO = new ShipmentDAOImp();
		orderDAO = new OrderDAOImp();
	}

	private Cookie getCookie(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();

		for (Cookie cookie : cookies) {
			if (cookie.getName().equalsIgnoreCase(name)) {
				return new Cookie(cookie.getName(), cookie.getValue());
			}
		}
		return null;
	}

	private int getUser(HttpServletRequest request) {
		Cookie cookie = getCookie(request, "user");
		if (cookie != null) {
			String username = cookie.getValue();

			try {
				return Integer.parseInt(username);
			} catch (Exception e) {
			}
		}
		return 0;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		System.out.println(action);

		try {
			switch (action) {
			case "/register":
				register(request, response);
				break;
			case "/loginform":
				loginform(request, response);
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
			// case "/addshoes":
			// 	addShoesItem(request, response);
			// 	break;
			// case "/addelectronic":
			// 	addElectronicItem(request, response);
			// 	break;
			// case "/addclothes":
			// 	addClothesItem(request, response);
			// 	break;
			// case "/addcart":
			// 	addCart(request, response);
			// 	break;
			case "/showcart":
				showCart(request, response);
				break;
			case "/deletecart":
			case "/cart":
				showCart(request, response);
				break;
			case "/selectsp":
				selectShipPayment(request, response);
				break;
			case "/order":
				showOrder(request, response);
				break;
			case "/login":
				login(request, response);
				break;
			default:
				listProduct(request, response);
				break;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void registerform(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("register.jsp");
	}

	public void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phoneNumber = request.getParameter("phoneNumber");
		String stateNo = request.getParameter("stateNo");
		String houseNo = request.getParameter("houseNo");
		String street = request.getParameter("street");
		String district = request.getParameter("district");
		String city = request.getParameter("city");
		String gender = request.getParameter("gender");
		String birth = request.getParameter("birth");
		String accountNum = request.getParameter("accountNum");

		String now = timeFormat.format(new Date());
		Account account = new Account(accountDAO.getMaxID() + 1, email, password, now);
		Phone phone = new Phone(phoneDAO.getMaxID() + 1, stateNo, phoneNumber);
		Fullname fullname = new Fullname(fullnameDAO.getMaxID() + 1, firstName, lastName);
		Address address = new Address(addressDAO.getMaxID() + 1, houseNo, street, district, city);
		Customer customer = new Customer(customerDAO.getMaxID() + 1, accountNum, gender, birth, account, fullname,
				phone, address);

		accountDAO.createAccount(account);
		phoneDAO.createPhone(phone);
		fullnameDAO.createFullName(fullname);
		addressDAO.insertAddress(address);
		customerDAO.insertCustomer(customer);

		RequestDispatcher dispatcher = request.getRequestDispatcher("registersuccess.jsp");
		dispatcher.forward(request, response);
	}

	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = new Cookie("user", "");
		response.addCookie(cookie);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	public void listBooks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean requireLogin = false;
		int user = getUser(request);
		if (requireLogin && user <= 0) {
			response.sendRedirect("login.jsp");
			return;
		}
		List<Comics> comics = bookDAO.findAllComics();
		List<Magazine> magazine = bookDAO.findAllMagazine();
		List<LightNovel> lightNovel = bookDAO.findAllLightNovel();
		request.setAttribute("listComics", comics);
		request.setAttribute("listMagazine", magazine);
		request.setAttribute("listLightNovel", lightNovel);
		RequestDispatcher dispatcher = request.getRequestDispatcher("booklist.jsp");
		dispatcher.forward(request, response);
	}

	public void listProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean requireLogin = false;
		int user = getUser(request);
		if (requireLogin && user <= 0) {
			response.sendRedirect("login.jsp");
			return;
		}

		// book;
		List<BookItem> comics = bookItemDAO.findAllComicsItem();
		List<BookItem> magazine = bookItemDAO.findAllMagazineItem();
		List<BookItem> lightNovel = bookItemDAO.findAllLightNovelItem();
		request.setAttribute("listComics", comics);
		request.setAttribute("listMagazine", magazine);
		request.setAttribute("listLightNovel", lightNovel);

		// shoes
		List<ShoesItem> boot = shoesItemDAO.findAllBootItem();
		List<ShoesItem> sandal = shoesItemDAO.findAllSandalItem();
		List<ShoesItem> sneakers = shoesItemDAO.findAllSneakerItem();
		request.setAttribute("listBoot", boot);
		request.setAttribute("listSandal", sandal);
		request.setAttribute("listSneakers", sneakers);

		// clothes
		List<ClothesItem> jeans = clothesItemDAO.findAllJeansItem();
		List<ClothesItem> shirt = clothesItemDAO.findAllShirtItem();
		List<ClothesItem> shorts = clothesItemDAO.findAllShortItem();
		request.setAttribute("listJeans", jeans);
		request.setAttribute("listShirt", shirt);
		request.setAttribute("listShort", shorts);

		// electronics
		List<ElectronicItem> mobile = electronicItemDAO.findAllMobileItem();
		List<ElectronicItem> laptop = electronicItemDAO.findAllLaptopItem();
		List<ElectronicItem> computer = electronicItemDAO.findAllComputerItem();
		request.setAttribute("listMobile", mobile);
		request.setAttribute("listLaptop", laptop);
		request.setAttribute("listComputer", computer);

		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	public void listShoes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean requireLogin = false;
		int user = getUser(request);
		if (requireLogin && user <= 0) {
			response.sendRedirect("login.jsp");
			return;
		}
		List<ShoesItem> boots = shoesItemDAO.findAllBootItem();
		List<ShoesItem> sandals = shoesItemDAO.findAllSandalItem();
		List<ShoesItem> sneakers = shoesItemDAO.findAllSneakerItem();
		request.setAttribute("listBoot", boots);
		request.setAttribute("listSandal", sandals);
		request.setAttribute("listSneaker", sneakers);
		RequestDispatcher dispatcher = request.getRequestDispatcher("booklist.jsp");
		dispatcher.forward(request, response);
	}

	public void addBookItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean requireLogin = true;
		int user = getUser(request);
		if (requireLogin && user <= 0) {
			response.sendRedirect("login.jsp");
			return;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/show");
		dispatcher.forward(request, response);
	}

	public void showCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean requireLogin = true;
		int user = getUser(request);
		if (requireLogin && user <= 0) {
			response.sendRedirect("login.jsp");
			return;
		}
		float totalPrice = 0;
		float discount = 0;
		Cart cart = cartDAO.findCart(user);

		List<HashMap<Integer, Integer>> books = cartDAO.getBookItemIDList(cart.getID());
		List<HashMap<Integer, Integer>> clothes = cartDAO.getClothesItemIDList(cart.getID());
		List<HashMap<Integer, Integer>> shoes = cartDAO.getShoesItem(cart.getID());
		List<HashMap<Integer, Integer>> electronics = cartDAO.getElectronicItemIDList(cart.getID());

		List<BookItem> bookItems = new ArrayList<BookItem>();
		List<ClothesItem> clothesItems = new ArrayList<ClothesItem>();
		List<ShoesItem> shoesItems = new ArrayList<ShoesItem>();
		List<ElectronicItem> electronicItems = new ArrayList<ElectronicItem>();
		
		
		for (HashMap<Integer,Integer> hashMap : books) {
			for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
				BookItem bookItem = bookItemDAO.getBookItemByID(entry.getKey());
				bookItems.add(bookItem);
				totalPrice += bookItem.getPrice() * entry.getValue();
				discount += bookItem.getDiscount() * entry.getValue();
			}
		}
		for (HashMap<Integer,Integer> hashMap : clothes) {
			for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
				ClothesItem clothesItem = clothesItemDAO.getClothesItemByID(entry.getKey());
				clothesItems.add(clothesItem);
				totalPrice += clothesItem.getPrice() * entry.getValue();
				discount += clothesItem.getDiscount() * entry.getValue();
			}
		}
		for (HashMap<Integer,Integer> hashMap : shoes) {
			for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
				ShoesItem shoesItem = shoesItemDAO.getShoesItemByID(entry.getKey());
				shoesItems.add(shoesItem);
				totalPrice += shoesItem.getPrice() * entry.getValue();
				discount += shoesItem.getDiscount() * entry.getValue();
			}
		}
		for (HashMap<Integer,Integer> hashMap : electronics) {
			for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
				ElectronicItem electronicItem = electronicItemDAO.getElectronicItemByID(entry.getKey());
				electronicItems.add(electronicItem);
				totalPrice += electronicItem.getPrice() * entry.getValue();
			}
		}

		request.setAttribute("bookItems", bookItems);
		request.setAttribute("clothesItems", clothesItems);
		request.setAttribute("shoesItems", shoesItems);
		request.setAttribute("electronicItems", electronicItems);

		request.setAttribute("totalPrice", totalPrice);

		RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
		dispatcher.forward(request, response);
	}

	public void selectShipPayment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("payShip.jsp");
		dispatcher.forward(request, response);
	}

	public void showOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int paymentID = Integer.parseInt(request.getParameter("payment"));
		int shipmentID = Integer.parseInt(request.getParameter("shipment"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("order.jsp");
		dispatcher.forward(request, response);
	}

	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		int accountID = accountDAO.getAccountID(email, password);
		if (accountDAO.validateAccount(email, password)) {
			int customerId = customerDAO.getCustomerID(accountID);
			Cookie cookie = new Cookie("customerId", String.valueOf(customerId));
			response.addCookie(cookie);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("loginfailed.jsp");
		}
	}

	public void loginform(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("account.html");
	}

}