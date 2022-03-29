package libraryProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;

/**
 * Project: Library Description: An online library database that allows a user
 * to log in, browse a series of titles from 4 genres and check out up to 3
 * books
 * 
 * @author Mark MacDonald & Sam Tilo
 */
public class MFrame extends JFrame {
	private Genre_Page genre;
	private StartMenu startPanel;
	private Genre_Horror horrorTitle;
	private Genre_Sci sciFiTitle;
	private Genre_Fantasy fantasyTitle;
	private Genre_Adult YATitle;
	private Summary_Page summary;
	private Cart_Items cart;
	private Exit exit;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MFrame frame = new MFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MFrame() {
		initilizePanels();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		actionListeners();
		contentPane.add(startPanel, BorderLayout.CENTER);
		startPanel.setLayout(null);
	}

	private void initilizePanels() {
		genre = new Genre_Page();
		startPanel = new StartMenu();
		horrorTitle = new Genre_Horror();
		sciFiTitle = new Genre_Sci();
		fantasyTitle = new Genre_Fantasy();
		YATitle = new Genre_Adult();
		summary = new Summary_Page();
		cart = new Cart_Items();
		exit = new Exit();
	}

	// create an empty array the user can add books to
	ArrayList<Book> myCart = new ArrayList<Book>();

	// create default user
	static User newUser = new User("newName", "newEmail", 0000000000);

	/**
	 * Action listeners for all buttons on all JPanels
	 */
	private void actionListeners() {
		// List of all available books in the library
		List<Book> allBooks = new ArrayList<Book>();
		Collections.addAll(allBooks, new Book("Dracula", "Bram Stoker", Genre.HORROR, 6),
				new Book("The Shining", "Stephen King", Genre.HORROR, 3),
				new Book("Magpie Lane", "Lucy Atkins", Genre.HORROR, 2),
				new Book("Frankenstein", "Mary Shelley", Genre.HORROR, 5),

				new Book("Dune", "Frank Herbert", Genre.SCIENCE_FICTION, 0),
				new Book("Annihilation", "Jeff Vandermeer", Genre.SCIENCE_FICTION, 3),
				new Book("1984", "George Orwell", Genre.SCIENCE_FICTION, 9),
				new Book("The Martian", "Andy Weir", Genre.SCIENCE_FICTION, 4),

				new Book("A Game of Thrones", "George R. R. Martin", Genre.FANTASY, 12),
				new Book("The Hobbit", "J. R. R. Tolkien", Genre.FANTASY, 4),
				new Book("The Poppy War", "R. F. Kuang", Genre.FANTASY, 2),
				new Book("The Name of the Wind", "Patrick Rothfuss", Genre.FANTASY, 5),

				new Book("Harry Potter and the Sorcerer's Stone", "J. K. Rowling", Genre.YOUNG_ADULT, 23),
				new Book("Shadow and Bone", "Leigh Bardugo", Genre.YOUNG_ADULT, 4),
				new Book("The Fault in Our Stars", "John Green", Genre.YOUNG_ADULT, 2),
				new Book("The Hunger Games", "Suzanne Collins", Genre.YOUNG_ADULT, 7));

		// Home Page to Genre Page
		startPanel.getStartBrowsingBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// set new user with input fields
				newUser.setName(StartMenu.nameTextField.getText());
				newUser.setEmail(StartMenu.emailTextField.getText());
				newUser.setPhoneNumber(Integer.parseInt(StartMenu.phoneTextField.getText()));

				// set account and cart labels
				genre.lblAccountLabel.setText("Account: " + newUser.getName());
				cart.lblAccountLabel.setText("Account: " + newUser.getName());
				genre.btnCartButton.setText("My cart: " + myCart.size());

				// move to Genre Browse Screen
				contentPane.remove(startPanel);
				contentPane.add(genre, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});

		// Genre to Title pages
		genresToTitles();

		// Horror Titles to Summary Page
		horrorToSummary(allBooks);

		// YA Titles to Summary Page
		yaToSummary(allBooks);

		// Fantasy Titles to Summary Page
		fantasyToSummary(allBooks);

		// SciFi Titles to Summary Page
		sciFiToSummary(allBooks);

		// Back to Genre Page
		backToGenre();

		// Back to Title Page from Summary Page
		backToTitlesPage(allBooks);

		// Add Book to Cart from Summary Page
		summaryAddButton(allBooks);

		// Your Cart Button
		toCartButton();

		// Checkout to Exit Page
		cart.getBtnCheckOutButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// arraylist of jlabels on checkout page
				ArrayList<JLabel> checkedItems = new ArrayList<>();
				checkedItems.add(exit.book1Label);
				checkedItems.add(exit.book2Label);
				checkedItems.add(exit.book3Label);

				// for each title in cart, set text on jlabel
				for (int i = 0; i < myCart.size(); i++) {
					checkedItems.get(i).setText(myCart.get(i).getTitle());
				}

				exit.lblThanksLabel.setText("Thanks for visiting " + MFrame.newUser.getName() + "!");
				exit.EmailLabel.setText(MFrame.newUser.getEmail());

				contentPane.remove(cart);
				contentPane.add(exit, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
	}

	/**
	 * Gets the Cart Button from the action listener method on current JPanel and
	 * switches view to Cart JPanel
	 */
	private void toCartButton() {
		genre.getBtnCartButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCartPageInfo();
				contentPane.remove(genre);
			}
		});

		horrorTitle.getBtnCartButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCartPageInfo();
				contentPane.remove(horrorTitle);
			}
		});

		fantasyTitle.getBtnCartButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCartPageInfo();
				contentPane.remove(fantasyTitle);
			}
		});

		YATitle.getBtnCartButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCartPageInfo();
				contentPane.remove(YATitle);
			}
		});

		sciFiTitle.getBtnCartButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCartPageInfo();
				contentPane.remove(sciFiTitle);
			}
		});

		summary.getCartBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCartPageInfo();
				contentPane.remove(summary);
			}
		});
	}

	/**
	 * Increments myCart value and decrements selected Book availability. If myCart
	 * value is 3, switches JPanel to Cart panel.
	 * 
	 * @param allBooks List of Books
	 * 
	 */
	private void summaryAddButton(List<Book> allBooks) {
		summary.getAddBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// locate book in allBooks
				int bookIndex = 0;

				for (Book b : allBooks) {
					if (summary.summaryLabel.getText().contains(b.getTitle())) {
						bookIndex = allBooks.indexOf(b);
					}
				}

				// check book availability
				if (allBooks.get(bookIndex).getAvailability() == 0) {
					JOptionPane.showMessageDialog(null, "Sorry! There's no copies available!");

					// add book to cart & update availability
				} else {
					// add to cart
					allBooks.get(bookIndex).addToCart(myCart);

					// check if cart is full
					if (myCart.size() == 3) {
						genre.btnCartButton.setText("My cart: " + myCart.size());

						// arraylist of jlabels on checkout page
						ArrayList<JLabel> cartItems = new ArrayList<>();
						cartItems.add(cart.book1Label);
						cartItems.add(cart.book2Label);
						cartItems.add(cart.book3Label);

						// for each title in cart, set text on jlabel
						for (int i = 0; i < myCart.size(); i++) {
							cartItems.get(i).setText(myCart.get(i).getTitle());
						}

						contentPane.remove(summary);
						contentPane.add(cart, BorderLayout.CENTER);
						contentPane.revalidate();
						contentPane.repaint();

						// return to Title page if cart is not full
					} else {
						switch (allBooks.get(bookIndex).getGenre()) {
						case HORROR:
							horrorTitle.getBtnCartButton().setText("My cart: " + myCart.size());
							contentPane.remove(summary);
							contentPane.add(horrorTitle, BorderLayout.CENTER);
							contentPane.revalidate();
							contentPane.repaint();
							break;
						case FANTASY:
							fantasyTitle.getBtnCartButton().setText("My cart: " + myCart.size());
							contentPane.remove(summary);
							contentPane.add(fantasyTitle, BorderLayout.CENTER);
							contentPane.revalidate();
							contentPane.repaint();
							break;
						case SCIENCE_FICTION:
							sciFiTitle.getBtnCartButton().setText("My cart: " + myCart.size());
							contentPane.remove(summary);
							contentPane.add(sciFiTitle, BorderLayout.CENTER);
							contentPane.revalidate();
							contentPane.repaint();
							break;
						case YOUNG_ADULT:
							YATitle.getBtnCartButton().setText("My cart: " + myCart.size());
							contentPane.remove(summary);
							contentPane.add(YATitle, BorderLayout.CENTER);
							contentPane.revalidate();
							contentPane.repaint();
							break;
						}
					}
				}
			}
		});
	}

	/**
	 * Switches back to Title page by clicking Back button on Summary page. Gets the
	 * selected book's genre to determine which Title page to return to.
	 * 
	 * @param allBooks List of Books
	 */
	private void backToTitlesPage(List<Book> allBooks) {
		summary.getBackToTitleBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int bookIndex = 0;

				for (Book b : allBooks) {
					if (summary.summaryLabel.getText().contains(b.getTitle())) {
						bookIndex = allBooks.indexOf(b);
					}
				}

				switch (allBooks.get(bookIndex).getGenre()) {
				case HORROR:
					horrorTitle.getBtnCartButton().setText("My cart: " + myCart.size());
					contentPane.remove(summary);
					contentPane.add(horrorTitle, BorderLayout.CENTER);
					contentPane.revalidate();
					contentPane.repaint();
					break;
				case FANTASY:
					fantasyTitle.getBtnCartButton().setText("My cart: " + myCart.size());
					contentPane.remove(summary);
					contentPane.add(fantasyTitle, BorderLayout.CENTER);
					contentPane.revalidate();
					contentPane.repaint();
					break;
				case SCIENCE_FICTION:
					sciFiTitle.getBtnCartButton().setText("My cart: " + myCart.size());
					contentPane.remove(summary);
					contentPane.add(sciFiTitle, BorderLayout.CENTER);
					contentPane.revalidate();
					contentPane.repaint();
					break;
				case YOUNG_ADULT:
					YATitle.getBtnCartButton().setText("My cart: " + myCart.size());
					contentPane.remove(summary);
					contentPane.add(YATitle, BorderLayout.CENTER);
					contentPane.revalidate();
					contentPane.repaint();
					break;
				}

			}
		});
	}

	/**
	 * Switches back to Genre page by clicking Back button on current Title page.
	 */
	private void backToGenre() {
		horrorTitle.getBtnBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				genre.btnCartButton.setText("My cart: " + myCart.size());

				contentPane.remove(horrorTitle);
				contentPane.add(genre, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});

		YATitle.getBtnBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				genre.btnCartButton.setText("My cart: " + myCart.size());

				contentPane.remove(YATitle);
				contentPane.add(genre, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});

		fantasyTitle.getBtnBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				genre.btnCartButton.setText("My cart: " + myCart.size());

				contentPane.remove(fantasyTitle);
				contentPane.add(genre, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});

		sciFiTitle.getBtnBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				genre.btnCartButton.setText("My cart: " + myCart.size());

				contentPane.remove(sciFiTitle);
				contentPane.add(genre, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});

		cart.getBtnBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				genre.btnCartButton.setText("My cart: " + myCart.size());

				contentPane.remove(cart);
				contentPane.add(genre, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
	}

	/**
	 * Gets summary for selected title from Summaries.txt file. Shows title, author,
	 * and availability of selected book.
	 * 
	 * @param allBooks List of Books
	 */
	private void sciFiToSummary(List<Book> allBooks) {
		sciFiTitle.getAnnaButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int bookIndex = 0;

				for (Book b : allBooks) {
					if (sciFiTitle.getAnnaButton().getText() == b.getTitle()) {
						bookIndex = allBooks.indexOf(b);
					}
				}

				String bookSummary = generateSummary(allBooks, bookIndex);

				// move to Genre Browse Screen
				contentPane.remove(sciFiTitle);
				contentPane.add(summary, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();
			}

		});

		sciFiTitle.getDuneButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int bookIndex = 0;

				for (Book b : allBooks) {
					if (sciFiTitle.getDuneButton().getText() == b.getTitle()) {
						bookIndex = allBooks.indexOf(b);
					}
				}

				String bookSummary = generateSummary(allBooks, bookIndex);

				// move to Genre Browse Screen
				contentPane.remove(sciFiTitle);
				contentPane.add(summary, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();
			}

		});

		sciFiTitle.getBtn1984Button().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int bookIndex = 0;

				for (Book b : allBooks) {
					if (sciFiTitle.getBtn1984Button().getText() == b.getTitle()) {
						bookIndex = allBooks.indexOf(b);
					}
				}

				String bookSummary = generateSummary(allBooks, bookIndex);

				// move to Genre Browse Screen
				contentPane.remove(sciFiTitle);
				contentPane.add(summary, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();
			}

		});

		sciFiTitle.getMartianButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int bookIndex = 0;

				for (Book b : allBooks) {
					if (sciFiTitle.getMartianButton().getText() == b.getTitle()) {
						bookIndex = allBooks.indexOf(b);
					}
				}

				String bookSummary = generateSummary(allBooks, bookIndex);

				// move to Genre Browse Screen
				contentPane.remove(sciFiTitle);
				contentPane.add(summary, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();
			}

		});
	}

	/**
	 * Gets summary for selected title from Summaries.txt file. Shows title, author,
	 * and availability of selected book.
	 * 
	 * @param allBooks List of Books
	 */
	private void fantasyToSummary(List<Book> allBooks) {
		fantasyTitle.getGameThrones().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int bookIndex = 0;

				for (Book b : allBooks) {
					if (b.getTitle() == "A Game of Thrones") {
						bookIndex = allBooks.indexOf(b);
					}
				}

				String bookSummary = generateSummary(allBooks, bookIndex);

				// move to Genre Browse Screen
				contentPane.remove(fantasyTitle);
				contentPane.add(summary, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();
			}

		});

		fantasyTitle.getHobbitButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int bookIndex = 0;

				for (Book b : allBooks) {
					if (b.getTitle() == "The Hobbit") {
						bookIndex = allBooks.indexOf(b);
					}
				}

				String bookSummary = generateSummary(allBooks, bookIndex);

				// move to Genre Browse Screen
				contentPane.remove(fantasyTitle);
				contentPane.add(summary, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();
			}

		});

		fantasyTitle.getPoppyButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int bookIndex = 0;

				for (Book b : allBooks) {
					if (b.getTitle() == "The Poppy War") {
						bookIndex = allBooks.indexOf(b);
					}
				}

				String bookSummary = generateSummary(allBooks, bookIndex);

				// move to Genre Browse Screen
				contentPane.remove(fantasyTitle);
				contentPane.add(summary, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();
			}

		});

		fantasyTitle.getWindButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int bookIndex = 0;

				for (Book b : allBooks) {
					if (b.getTitle() == "The Name of the Wind") {
						bookIndex = allBooks.indexOf(b);
					}
				}

				String bookSummary = generateSummary(allBooks, bookIndex);

				// move to Genre Browse Screen
				contentPane.remove(fantasyTitle);
				contentPane.add(summary, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();
			}

		});
	}

	/**
	 * Gets summary for selected title from Summaries.txt file. Shows title, author,
	 * and availability of selected book.
	 * 
	 * @param allBooks List of Books
	 */
	private void yaToSummary(List<Book> allBooks) {
		YATitle.getPotter().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int bookIndex = 0;

				for (Book b : allBooks) {
					if (b.getTitle() == "Harry Potter and the Sorcerer's Stone") {
						bookIndex = allBooks.indexOf(b);
					}
				}

				generateSummary(allBooks, bookIndex);

				// move to Genre Browse Screen
				contentPane.remove(YATitle);
				contentPane.add(summary, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();
			}

		});

		YATitle.getShadowButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int bookIndex = 0;

				for (Book b : allBooks) {
					if (b.getTitle() == "Shadow and Bone") {
						bookIndex = allBooks.indexOf(b);
					}
				}

				String bookSummary = generateSummary(allBooks, bookIndex);

				// move to Genre Browse Screen
				contentPane.remove(YATitle);
				contentPane.add(summary, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();
			}

		});

		YATitle.getFaultButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int bookIndex = 0;

				for (Book b : allBooks) {
					if (b.getTitle() == "The Fault in Our Stars") {
						bookIndex = allBooks.indexOf(b);
					}
				}

				String bookSummary = generateSummary(allBooks, bookIndex);

				// move to Genre Browse Screen
				contentPane.remove(YATitle);
				contentPane.add(summary, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();
			}

		});

		YATitle.getHungerButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int bookIndex = 0;

				for (Book b : allBooks) {
					if (b.getTitle() == "The Hunger Games") {
						bookIndex = allBooks.indexOf(b);
					}
				}

				String bookSummary = generateSummary(allBooks, bookIndex);

				// move to Genre Browse Screen
				contentPane.remove(YATitle);
				contentPane.add(summary, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();
			}

		});
	}

	/**
	 * Gets summary for selected title from Summaries.txt file. Shows title, author,
	 * and availability of selected book.
	 * 
	 * @param allBooks List of Books
	 */
	private void horrorToSummary(List<Book> allBooks) {
		horrorTitle.getDracButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int bookIndex = 0;

				for (Book b : allBooks) {
					if (horrorTitle.getDracButton().getText() == b.getTitle()) {
						bookIndex = allBooks.indexOf(b);
					}
				}

				String bookSummary = generateSummary(allBooks, bookIndex);

				// move to Genre Browse Screen
				contentPane.remove(horrorTitle);
				contentPane.add(summary, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();
			}

		});

		horrorTitle.getShiningButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int bookIndex = 0;

				for (Book b : allBooks) {
					if (horrorTitle.getShiningButton().getText() == b.getTitle()) {
						bookIndex = allBooks.indexOf(b);
					}
				}

				String bookSummary = generateSummary(allBooks, bookIndex);

				// move to Genre Browse Screen
				contentPane.remove(horrorTitle);
				contentPane.add(summary, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();
			}

		});

		horrorTitle.getMagpieButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int bookIndex = 0;

				for (Book b : allBooks) {
					if (horrorTitle.getMagpieButton().getText() == b.getTitle()) {
						bookIndex = allBooks.indexOf(b);
					}
				}

				String bookSummary = generateSummary(allBooks, bookIndex);

				// move to Genre Browse Screen
				contentPane.remove(horrorTitle);
				contentPane.add(summary, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();
			}

		});

		horrorTitle.getFrankButton().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int bookIndex = 0;

				for (Book b : allBooks) {
					if (horrorTitle.getFrankButton().getText() == b.getTitle()) {
						bookIndex = allBooks.indexOf(b);
					}
				}

				String bookSummary = generateSummary(allBooks, bookIndex);

				// move to Genre Browse Screen
				contentPane.remove(horrorTitle);
				contentPane.add(summary, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();
			}

		});
	}

	/**
	 * Gets Title page for selected genre.
	 */
	private void genresToTitles() {
		genre.getHorrorButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// set account and cart labels
				horrorTitle.getLblAccountLabel().setText("Account: " + newUser.getName());
				horrorTitle.getBtnCartButton().setText("My cart: " + myCart.size());

				contentPane.remove(genre);
				contentPane.add(horrorTitle, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();

			}
		});

		genre.getBtnScifi().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// set account and cart labels
				sciFiTitle.getLblAccountLabel().setText("Account: " + newUser.getName());
				sciFiTitle.getBtnCartButton().setText("My cart: " + myCart.size());
				contentPane.remove(genre);
				contentPane.add(sciFiTitle, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});

		genre.getBtnFantasyButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// set account and cart labels
				fantasyTitle.getLblAccountLabel().setText("Account: " + newUser.getName());
				fantasyTitle.getBtnCartButton().setText("My cart: " + myCart.size());

				contentPane.remove(genre);
				contentPane.add(fantasyTitle, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});

		genre.getBtnAdultButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// set account and cart labels
				YATitle.getLblAccountLabel().setText("Account: " + newUser.getName());
				YATitle.getBtnCartButton().setText("My cart: " + myCart.size());

				contentPane.remove(genre);
				contentPane.add(YATitle, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();
			}
		});

		genre.getBtnCartButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(genre);
				contentPane.add(cart, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();

			}
		});
	}

	/**
	 * Set Summary Page Info
	 * 
	 * @param allBooks  list of all available library books
	 * @param bookIndex allBooks index of book being selected
	 * @return a JLabel containing the selected book's title, author, summary and
	 *         availability
	 */
	private String generateSummary(List<Book> allBooks, int bookIndex) {
		// set account and cart labels
		summary.lblAccountLabel.setText("Account: " + newUser.getName());
		summary.btnCartButton.setText("My cart: " + myCart.size());

		String bookSummary = null;
		try (Scanner input = new Scanner(new File("Summaries.txt"))) {
			while (input.hasNextLine()) {
				if (allBooks.get(bookIndex).getTitle().equals(input.nextLine().trim())) {
					bookSummary = input.nextLine();
				}
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		// set JLable with book preview information
		summary.summaryLabel.setText("<html>" + allBooks.get(bookIndex).getTitle() + "<br>"
				+ allBooks.get(bookIndex).getAuthor() + "<br><br>" + bookSummary + "<br><br>Availability: "
				+ allBooks.get(bookIndex).getAvailability() + "</html>");

		return bookSummary;
	}

	/**
	 * Set Cart Page Info Displays all books taken from myCart array on Cart page
	 */
	private void setCartPageInfo() {
		// arraylist of jlabels on checkout page
		ArrayList<JLabel> cartItems = new ArrayList<>();
		cartItems.add(cart.book1Label);
		cartItems.add(cart.book2Label);
		cartItems.add(cart.book3Label);

		// for each title in cart, set text on jlabel
		for (int i = 0; i < myCart.size(); i++) {
			cartItems.get(i).setText(myCart.get(i).getTitle());
		}

		contentPane.add(cart, BorderLayout.CENTER);
		cart.revalidate();
		cart.repaint();
		contentPane.revalidate();
		contentPane.repaint();
	}
}
