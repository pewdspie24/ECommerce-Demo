package controller.userController;

import java.io.IOException;
import java.io.PrintWriter;
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
import controller.orderDAO.VoucherDAO;
import controller.orderDAO.VoucherDAOImp;
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
import model.order.AbroadShipment;
import model.order.Cart;
import model.order.EconomicalShipment;
import model.order.FastShipment;
import model.order.Order;
import model.order.Payment;
import model.order.Shipment;
import model.order.Voucher;
import model.order.VoucherConstant;
import model.order.VoucherPercentage;
import model.shoes.Boot;
import model.shoes.Sandal;
import model.shoes.ShoesItem;
import model.shoes.Sneaker;

@WebServlet(urlPatterns = { "/", "" })
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
	private VoucherDAOImp voucherDAO;
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
		voucherDAO = new VoucherDAOImp();
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

	private int getcustomerID(HttpServletRequest request) {
		Cookie cookie = getCookie(request, "customerID");
		if (cookie != null) {
			String customerIDname = cookie.getValue();

			try {
				return Integer.parseInt(customerIDname);
			} catch (Exception e) {
			}
		}
		return 0;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		// System.out.println(action);
		// String firstName = "Nguyen";
		// String lastName = "Nam";
		// String email = "1";
		// String password = "1";
		// String phoneNumber = "000111";
		// String stateNo = "024";
		// String houseNo = "106";
		// String street = "ngõ 136 NH - ĐX";
		// String district = "Gia Lâm";
		// String city = "Hà Nội";
		// String gender = "Nam";
		// String birth = "00/01/2021";
		// String accountNum = "19199191";

		// String now = timeFormat.format(new Date());
		// Account account = new Account(accountDAO.getMaxID() + 1, email, password,
		// now);
		// Phone phone = new Phone(phoneDAO.getMaxID() + 1, stateNo, phoneNumber);
		// Fullname fullname = new Fullname(fullnameDAO.getMaxID() + 1, firstName,
		// lastName);
		// Address address = new Address(addressDAO.getMaxID() + 1, houseNo, street,
		// district, city);
		// Customer customer = new Customer(customerDAO.getMaxID() + 1, accountNum,
		// gender, birth, account, fullname,
		// phone, address);

		// accountDAO.createAccount(account);
		// phoneDAO.createPhone(phone);
		// fullnameDAO.createFullName(fullname);
		// addressDAO.insertAddress(address);
		// customerDAO.insertCustomer(customer);

		try {
			switch (action.toLowerCase()) {
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
			case "/addshoes":
				addShoesItem(request, response);
				break;
			case "/addelectronic":
				addElectronicItem(request, response);
				break;
			case "/addclothes":
				addClothesItem(request, response);
				break;
			// case "/addcart":
			// addCart(request, response);
			// break;
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
			case "/login":
				login(request, response);
				break;
			case "/checkoutdetail":
				checkoutDetail(request, response);
				break;
			case "/order":
				order(request, response);
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

	public void checkoutDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean requireLogin = true;
		int customerID = getcustomerID(request);
		if (requireLogin && customerID <= 0) {
			response.sendRedirect("account.html");
			return;
		}
		float totalPrice = 0;
		float discount = 0;
		Cart cart = cartDAO.findCart(customerID);
		if (cart == null) {
			cart = new Cart(0, customerDAO.viewCustomer(customerID), dateFormat.format(new Date()),
					dateFormat.format(new Date()), 0, 0);
			cartDAO.createCart(cart);
		}

		HashMap<Integer, Integer> books = cartDAO.getBookItemIDList(cart.getID());
		HashMap<Integer, Integer> clothes = cartDAO.getClothesItemIDList(cart.getID());
		HashMap<Integer, Integer> shoes = cartDAO.getShoesItem(cart.getID());
		HashMap<Integer, Integer> electronics = cartDAO.getElectronicItemIDList(cart.getID());

		List<BookItem> bookItems = new ArrayList<BookItem>();
		List<ClothesItem> clothesItems = new ArrayList<ClothesItem>();
		List<ShoesItem> shoesItems = new ArrayList<ShoesItem>();
		List<ElectronicItem> electronicItems = new ArrayList<ElectronicItem>();
		List<Integer> bookQuantity = new ArrayList<Integer>();
		List<Integer> clothesQuantity = new ArrayList<Integer>();
		List<Integer> shoesQuantity = new ArrayList<Integer>();
		List<Integer> electronicQuantity = new ArrayList<Integer>();
		List<Float> bookPrice = new ArrayList<Float>();
		List<Float> clothesPrice = new ArrayList<Float>();
		List<Float> shoesPrice = new ArrayList<Float>();
		List<Float> electronicPrice = new ArrayList<Float>();

		for (Map.Entry<Integer, Integer> entry : books.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
			BookItem bookItem = bookItemDAO.getBookItemByID(entry.getKey());
			bookItems.add(bookItem);
			bookQuantity.add(entry.getValue());
			totalPrice += bookItem.getPrice() * entry.getValue();
			bookPrice.add(bookItem.getPrice() * entry.getValue());
			discount += bookItem.getDiscount() * entry.getValue();
		}

		for (Map.Entry<Integer, Integer> entry : clothes.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
			ClothesItem clothesItem = clothesItemDAO.getClothesItemByID(entry.getKey());
			clothesItems.add(clothesItem);
			clothesPrice.add(clothesItem.getPrice() * entry.getValue());
			clothesQuantity.add(entry.getValue());
			totalPrice += clothesItem.getPrice() * entry.getValue();
			discount += clothesItem.getDiscount() * entry.getValue();
		}

		for (Map.Entry<Integer, Integer> entry : shoes.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
			ShoesItem shoesItem = shoesItemDAO.getShoesItemByID(entry.getKey());
			shoesItems.add(shoesItem);
			shoesPrice.add(shoesItem.getPrice() * entry.getValue());
			shoesQuantity.add(entry.getValue());
			totalPrice += shoesItem.getPrice() * entry.getValue();
			discount += shoesItem.getDiscount() * entry.getValue();
		}

		for (Map.Entry<Integer, Integer> entry : electronics.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
			ElectronicItem electronicItem = electronicItemDAO.getElectronicItemByID(entry.getKey());
			electronicItems.add(electronicItem);
			electronicPrice.add(electronicItem.getPrice() * entry.getValue());
			electronicQuantity.add(entry.getValue());
			totalPrice += electronicItem.getPrice() * entry.getValue();
			discount += electronicItem.getDiscount() * entry.getValue();
		}

		request.setAttribute("bookItems", bookItems);
		request.setAttribute("clothesItems", clothesItems);
		request.setAttribute("shoesItems", shoesItems);
		request.setAttribute("electronicItems", electronicItems);

		request.setAttribute("bookQuantity", bookQuantity);
		request.setAttribute("clothesQuantity", clothesQuantity);
		request.setAttribute("shoesQuantity", shoesQuantity);
		request.setAttribute("electronicQuantity", electronicQuantity);

		request.setAttribute("bookPrice", bookPrice);
		request.setAttribute("clothesPrice", clothesPrice);
		request.setAttribute("shoesPrice", shoesPrice);
		request.setAttribute("electronicPrice", electronicPrice);

		request.setAttribute("totalPrice", totalPrice);
		request.setAttribute("discount", discount);
		request.setAttribute("total", totalPrice - discount);

		RequestDispatcher dispatcher = request.getRequestDispatcher("checkoutDetail.jsp");
		dispatcher.forward(request, response);
	}
	
	public void order(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean requireLogin = true;
		int customerID = getcustomerID(request);
		int shipmentID = Integer.parseInt(request.getParameter("shipment"));
		int voucherID = Integer.parseInt(request.getParameter("voucher"));
		int paymentID = Integer.parseInt(request.getParameter("payment"));
//		System.out.println("DCMM"+voucherID);
		if (requireLogin && customerID <= 0) {
			response.sendRedirect("account.html");
			return;
		}
		float totalPrice = 0;
		float discount = 0;
		Cart cart = cartDAO.findCart(customerID);
		if (cart == null) {
			cart = new Cart(0, customerDAO.viewCustomer(customerID), dateFormat.format(new Date()),
					dateFormat.format(new Date()), 0, 0);
			cartDAO.createCart(cart);
		}

		HashMap<Integer, Integer> books = cartDAO.getBookItemIDList(cart.getID());
		HashMap<Integer, Integer> clothes = cartDAO.getClothesItemIDList(cart.getID());
		HashMap<Integer, Integer> shoes = cartDAO.getShoesItem(cart.getID());
		HashMap<Integer, Integer> electronics = cartDAO.getElectronicItemIDList(cart.getID());
		Shipment shipment = shipmentDAO.getShipmentByID(shipmentID);
		System.out.println("DCMM"+voucherID);
		Voucher voucher1 = voucherDAO.getVoucherByID(voucherID);
		Payment payment = paymentDAO.getPaymentByID(paymentID);
		
//		if (shipmentID == 3){
//			FastShipment shipment = shipmentDAO.findFastShipmentByID(shipmentID);
//		}else if(shipmentID == 2){
//			EconomicalShipment shipment = shipmentDAO.findEconomicalShipmentByID(shipmentID);
//		}
//		else{
//			AbroadShipment shipment = shipmentDAO.findAbroadShipmentByID(shipmentID);
//		}
		
		List<BookItem> bookItems = new ArrayList<BookItem>();
		List<ClothesItem> clothesItems = new ArrayList<ClothesItem>();
		List<ShoesItem> shoesItems = new ArrayList<ShoesItem>();
		List<ElectronicItem> electronicItems = new ArrayList<ElectronicItem>();
		List<Integer> bookQuantity = new ArrayList<Integer>();
		List<Integer> clothesQuantity = new ArrayList<Integer>();
		List<Integer> shoesQuantity = new ArrayList<Integer>();
		List<Integer> electronicQuantity = new ArrayList<Integer>();
		List<Float> bookPrice = new ArrayList<Float>();
		List<Float> clothesPrice = new ArrayList<Float>();
		List<Float> shoesPrice = new ArrayList<Float>();
		List<Float> electronicPrice = new ArrayList<Float>();

		for (Map.Entry<Integer, Integer> entry : books.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
			BookItem bookItem = bookItemDAO.getBookItemByID(entry.getKey());
			bookItems.add(bookItem);
			bookQuantity.add(entry.getValue());
			totalPrice += bookItem.getPrice() * entry.getValue();
			bookPrice.add(bookItem.getPrice() * entry.getValue());
			discount += bookItem.getDiscount() * entry.getValue();
		}

		for (Map.Entry<Integer, Integer> entry : clothes.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
			ClothesItem clothesItem = clothesItemDAO.getClothesItemByID(entry.getKey());
			clothesItems.add(clothesItem);
			clothesPrice.add(clothesItem.getPrice() * entry.getValue());
			clothesQuantity.add(entry.getValue());
			totalPrice += clothesItem.getPrice() * entry.getValue();
			discount += clothesItem.getDiscount() * entry.getValue();
		}

		for (Map.Entry<Integer, Integer> entry : shoes.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
			ShoesItem shoesItem = shoesItemDAO.getShoesItemByID(entry.getKey());
			shoesItems.add(shoesItem);
			shoesPrice.add(shoesItem.getPrice() * entry.getValue());
			shoesQuantity.add(entry.getValue());
			totalPrice += shoesItem.getPrice() * entry.getValue();
			discount += shoesItem.getDiscount() * entry.getValue();
		}

		for (Map.Entry<Integer, Integer> entry : electronics.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
			ElectronicItem electronicItem = electronicItemDAO.getElectronicItemByID(entry.getKey());
			electronicItems.add(electronicItem);
			electronicPrice.add(electronicItem.getPrice() * entry.getValue());
			electronicQuantity.add(entry.getValue());
			totalPrice += electronicItem.getPrice() * entry.getValue();
			discount += electronicItem.getDiscount() * entry.getValue();
		}
		
		float voucherdiscount = 0;
		float shipmentPrice = shipment.getPrice();
		int type = voucherDAO.checkType(voucherID);
		if(type == 2){
			VoucherConstant vc = voucherDAO.findVoucherConstantByID(voucherID);
			voucherdiscount = vc.getQuantity();
		}else{
			VoucherPercentage vc = voucherDAO.findVoucherPercentageByID(voucherID);
			voucherdiscount = totalPrice*vc.getPercentage()/100;
		}
		
		payment.setAmount(totalPrice - discount - voucherdiscount);
		payment.setShipment(shipment);
		payment.setVoucher(voucher1);
		Order order = new Order(0, cart, payment, customerDAO.viewCustomer(customerID), dateFormat.format(new Date()));
		orderDAO.insertOrder(order);
		
		request.setAttribute("bookItems", bookItems);
		request.setAttribute("clothesItems", clothesItems);
		request.setAttribute("shoesItems", shoesItems);
		request.setAttribute("electronicItems", electronicItems);

		request.setAttribute("bookQuantity", bookQuantity);
		request.setAttribute("clothesQuantity", clothesQuantity);
		request.setAttribute("shoesQuantity", shoesQuantity);
		request.setAttribute("electronicQuantity", electronicQuantity);

		request.setAttribute("bookPrice", bookPrice);
		request.setAttribute("clothesPrice", clothesPrice);
		request.setAttribute("shoesPrice", shoesPrice);
		request.setAttribute("electronicPrice", electronicPrice);

		request.setAttribute("totalPrice", totalPrice);
		request.setAttribute("voucherDiscount", voucherdiscount);
		request.setAttribute("discount", discount+voucherdiscount);
		request.setAttribute("shipmentPrice", shipmentPrice);
		request.setAttribute("total", totalPrice - discount - voucherdiscount + shipmentPrice);

		RequestDispatcher dispatcher = request.getRequestDispatcher("order.jsp");
		dispatcher.forward(request, response);
	}

	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = new Cookie("customerID", "");
		response.addCookie(cookie);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	public void listBooks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean requireLogin = false;
		int customerID = getcustomerID(request);
		if (requireLogin && customerID <= 0) {
			response.sendRedirect("account.html");
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
		int customerID = getcustomerID(request);
		if (requireLogin && customerID <= 0) {
			response.sendRedirect("account.html");
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

		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		dispatcher.forward(request, response);
	}

	public void listShoes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean requireLogin = false;
		int customerID = getcustomerID(request);
		if (requireLogin && customerID <= 0) {
			response.sendRedirect("account.html");
			return;
		}
		List<ShoesItem> boots = shoesItemDAO.findAllBootItem();
		List<ShoesItem> sandals = shoesItemDAO.findAllSandalItem();
		List<ShoesItem> sneakers = shoesItemDAO.findAllSneakerItem();
		request.setAttribute("listBoot", boots);
		request.setAttribute("listSandal", sandals);
		request.setAttribute("listSneaker", sneakers);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		dispatcher.forward(request, response);
	}

	public void addBookItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean requireLogin = true;
		int customerID = getcustomerID(request);
		if (requireLogin && customerID <= 0) {
			response.sendRedirect("account.html");
			return;
		}
		String bookItemId = request.getParameter("bookItemId");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		BookItem bookItem = bookItemDAO.getBookItemByID(Integer.parseInt(bookItemId));
		Cart cart = cartDAO.findCart(customerID);
		if (cart == null) {
			cart = new Cart(0, customerDAO.viewCustomer(customerID), dateFormat.format(new Date()),
					dateFormat.format(new Date()), 0, 0);
			cartDAO.createCart(cart);
		}
		if (cartDAO.checkBookitem(cart, bookItem) > 0){
			System.out.println("abc");
			cartDAO.updateBookitem(cart, bookItem);
		}
		else{
			cartDAO.addBookitem(cart, bookItem, quantity);
		}
		
		PrintWriter writer = response.getWriter();
		writer.write("Added bookID " + bookItem.getID() + " to cart");
		writer.close();
	}

	public void addShoesItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean requireLogin = true;
		int customerID = getcustomerID(request);
		if (requireLogin && customerID <= 0) {
			response.sendRedirect("account.html");
			return;
		}
		String shoesItemId = request.getParameter("shoesItemId");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		ShoesItem shoesItem = shoesItemDAO.getShoesItemByID(Integer.parseInt(shoesItemId));
		Cart cart = cartDAO.findCart(customerID);
		if (cart == null) {
			cart = new Cart(0, customerDAO.viewCustomer(customerID), dateFormat.format(new Date()),
					dateFormat.format(new Date()), 0, 0);
			cartDAO.createCart(cart);
		}
		if (cartDAO.checkShoesitem(cart, shoesItem) > 0){
			cartDAO.updateShoesitem(cart, shoesItem);
		}
		else{
			cartDAO.addShoesItem(cart, shoesItem, quantity);
		}
		
		PrintWriter writer = response.getWriter();
		writer.write("Added shoesID " + shoesItem.getID() + " to cart");
		writer.close();
	}

	public void addClothesItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean requireLogin = true;
		int customerID = getcustomerID(request);
		if (requireLogin && customerID <= 0) {
			response.sendRedirect("account.html");
			return;
		}
		String clothesItemId = request.getParameter("clothesItemId");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		ClothesItem clothesItem = clothesItemDAO.getClothesItemByID(Integer.parseInt(clothesItemId));
		Cart cart = cartDAO.findCart(customerID);
		if (cart == null) {
			cart = new Cart(0, customerDAO.viewCustomer(customerID), dateFormat.format(new Date()),
					dateFormat.format(new Date()), 0, 0);
			cartDAO.createCart(cart);
		}
		if (cartDAO.checkClothesitem(cart, clothesItem) > 0){
			cartDAO.updateClothesitem(cart, clothesItem);
		}
		else{
			cartDAO.addClothesItem(cart, clothesItem, quantity);
		}

		PrintWriter writer = response.getWriter();
		writer.write("Added clothesID " + clothesItem.getID() + " to cart");
		writer.close();
	}

	public void addElectronicItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean requireLogin = true;
		int customerID = getcustomerID(request);
		if (requireLogin && customerID <= 0) {
			response.sendRedirect("account.html");
			return;
		}
		String electronicItemId = request.getParameter("electronicItemId");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		ElectronicItem electronicItem = electronicItemDAO.getElectronicItemByID(Integer.parseInt(electronicItemId));
		Cart cart = cartDAO.findCart(customerID);
		if (cart == null) {
			cart = new Cart(0, customerDAO.viewCustomer(customerID), dateFormat.format(new Date()),
					dateFormat.format(new Date()), 0, 0);
			cartDAO.createCart(cart);
		}
		if (cartDAO.checkElectronicitem(cart, electronicItem) > 0){
			cartDAO.updateElectronicitem(cart, electronicItem);
		}
		else{
			cartDAO.addElectronicItem(cart, electronicItem, quantity);
		}

		PrintWriter writer = response.getWriter();
		writer.write("Added electronicID " + electronicItem.getID() + " to cart");
		writer.close();
	}

	public void showCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean requireLogin = true;
		int customerID = getcustomerID(request);
		if (requireLogin && customerID <= 0) {
			response.sendRedirect("account.html");
			return;
		}
		float totalPrice = 0;
		float discount = 0;
		Cart cart = cartDAO.findCart(customerID);
		if (cart == null) {
			cart = new Cart(0, customerDAO.viewCustomer(customerID), dateFormat.format(new Date()),
					dateFormat.format(new Date()), 0, 0);
			cartDAO.createCart(cart);
		}

		HashMap<Integer, Integer> books = cartDAO.getBookItemIDList(cart.getID());
		HashMap<Integer, Integer> clothes = cartDAO.getClothesItemIDList(cart.getID());
		HashMap<Integer, Integer> shoes = cartDAO.getShoesItem(cart.getID());
		HashMap<Integer, Integer> electronics = cartDAO.getElectronicItemIDList(cart.getID());

		List<BookItem> bookItems = new ArrayList<BookItem>();
		List<ClothesItem> clothesItems = new ArrayList<ClothesItem>();
		List<ShoesItem> shoesItems = new ArrayList<ShoesItem>();
		List<ElectronicItem> electronicItems = new ArrayList<ElectronicItem>();
		List<Integer> bookQuantity = new ArrayList<Integer>();
		List<Integer> clothesQuantity = new ArrayList<Integer>();
		List<Integer> shoesQuantity = new ArrayList<Integer>();
		List<Integer> electronicQuantity = new ArrayList<Integer>();
		List<Float> bookPrice = new ArrayList<Float>();
		List<Float> clothesPrice = new ArrayList<Float>();
		List<Float> shoesPrice = new ArrayList<Float>();
		List<Float> electronicPrice = new ArrayList<Float>();


		for (Map.Entry<Integer, Integer> entry : books.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
			BookItem bookItem = bookItemDAO.getBookItemByID(entry.getKey());
			bookItems.add(bookItem);
			bookQuantity.add(entry.getValue());
			totalPrice += bookItem.getPrice() * entry.getValue();
			bookPrice.add(bookItem.getPrice() * entry.getValue());
			discount += bookItem.getDiscount() * entry.getValue();
		}

		for (Map.Entry<Integer, Integer> entry : clothes.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
			ClothesItem clothesItem = clothesItemDAO.getClothesItemByID(entry.getKey());
			clothesItems.add(clothesItem);
			clothesPrice.add(clothesItem.getPrice() * entry.getValue());
			clothesQuantity.add(entry.getValue());
			totalPrice += clothesItem.getPrice() * entry.getValue();
			discount += clothesItem.getDiscount() * entry.getValue();
		}

		for (Map.Entry<Integer, Integer> entry : shoes.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
			ShoesItem shoesItem = shoesItemDAO.getShoesItemByID(entry.getKey());
			shoesItems.add(shoesItem);
			shoesPrice.add(shoesItem.getPrice() * entry.getValue());
			shoesQuantity.add(entry.getValue());
			totalPrice += shoesItem.getPrice() * entry.getValue();
			discount += shoesItem.getDiscount() * entry.getValue();
		}

		for (Map.Entry<Integer, Integer> entry : electronics.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
			ElectronicItem electronicItem = electronicItemDAO.getElectronicItemByID(entry.getKey());
			electronicItems.add(electronicItem);
			electronicPrice.add(electronicItem.getPrice() * entry.getValue());
			electronicQuantity.add(entry.getValue());
			totalPrice += electronicItem.getPrice() * entry.getValue();
			discount += electronicItem.getDiscount() * entry.getValue();
		}

		request.setAttribute("bookItems", bookItems);
		request.setAttribute("clothesItems", clothesItems);
		request.setAttribute("shoesItems", shoesItems);
		request.setAttribute("electronicItems", electronicItems);

		request.setAttribute("bookQuantity", bookQuantity);
		request.setAttribute("clothesQuantity", clothesQuantity);
		request.setAttribute("shoesQuantity", shoesQuantity);
		request.setAttribute("electronicQuantity", electronicQuantity);

		request.setAttribute("bookPrice", bookPrice);
		request.setAttribute("clothesPrice", clothesPrice);
		request.setAttribute("shoesPrice", shoesPrice);
		request.setAttribute("electronicPrice", electronicPrice);

		request.setAttribute("totalPrice", totalPrice);
		request.setAttribute("discount", discount);
		request.setAttribute("total", totalPrice - discount);

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