package household_account_book;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AveenoLoginUI implements ActionListener, ItemListener {
	public static void main(String[] args) {
		// JFrame 생성
		JFrame frame = new JFrame("가계부 로그인");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 500);
		frame.setLayout(null); // 절대 위치 사용

		// 배경색 설정
		frame.getContentPane().setBackground(Color.WHITE);

		// 로고 (텍스트로 대체 또는 이미지로 추가 가능)
		JLabel logoLabel = new JLabel(new ImageIcon("images/login_01.png"));
		logoLabel.setBounds(50, 30, 300, 50); // 위치와 크기 설정
		frame.add(logoLabel);

		// 아이디 입력 필드
		JTextField idField = new JTextField("admin");
		idField.setFont(new Font("Arial", Font.PLAIN, 16));
		idField.setBounds(50, 120, 300, 40);
		idField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		frame.add(idField);

		// 비밀번호 입력 필드
		JPasswordField passwordField = new JPasswordField("1234");
		passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
		passwordField.setBounds(50, 180, 300, 40);
		passwordField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		frame.add(passwordField);

		// 취소 버튼
		JButton cancelButton = new JButton(new ImageIcon("images/login_04.png"));
		cancelButton.setBounds(50, 260, 139, 55);
		frame.add(cancelButton);

		// 로그인 버튼
		JButton loginButton = new JButton(new ImageIcon("images/login_05.png"));
		loginButton.setBounds(210, 260, 139, 55);
		frame.add(loginButton);

		// 회원가입 링크
		JLabel signupLabel = new JLabel(new ImageIcon("images/login_06.png"));
		signupLabel.setHorizontalAlignment(SwingConstants.CENTER);
		signupLabel.setBounds(50, 320, 300, 30);
		frame.add(signupLabel);

		// 하드코딩된 ID와 비밀번호DB코드 자리
		String validId = "admin";
		String validPassword = "1234";

		// 로그인 버튼 동작
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputId = idField.getText();
				String inputPassword = new String(passwordField.getPassword());

				// 하드코딩된 값과 비교
				if (inputId.equals(validId) && inputPassword.equals(validPassword)) {
					// JOptionPane.showMessageDialog(frame, "로그인 성공!", "성공",
					// JOptionPane.INFORMATION_MESSAGE);
					frame.dispose(); // 로그인 창 닫기
					openMainWindow(inputId); // 메인 창 열기
				} else {
					JOptionPane.showMessageDialog(frame, "ID 또는 비밀번호가 잘못되었습니다.", "로그인 실패", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// 취소 버튼 동작
		cancelButton.addActionListener(e -> System.exit(0));

		// 창 보이기
		frame.setVisible(true);
	}

	private static void openMainWindow(String userId) {
		MainUI main = new MainUI(userId);
	}

	static class ButtonListener implements ActionListener {
		private final int buttonIndex;

		public ButtonListener(int buttonIndex) {
			this.buttonIndex = buttonIndex;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (buttonIndex == 0) {

			}

		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}

class MainUI implements ActionListener, ItemListener {
	JButton expenditureIcon,goalIcon,accountIcon,cardIcon,cashIcon ;
	JFrame mainFrame;
	JPanel mainPanel,targetPanel,accountPanel,cardPanel,cashPanel;
	public MainUI(String userId) {
		mainFrame = new JFrame("가계부 관리 - " + userId + "님");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(1200, 700); // 큰 창 크기 설정

		mainFrame.setLayout(new BorderLayout());

		// 좌측 메뉴 패널
		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
		menuPanel.setBackground(new Color(52, 73, 94));
		menuPanel.setPreferredSize(new Dimension(100, mainFrame.getHeight()));

		// 메뉴 버튼 생성
		ImageIcon[] menuItems = { new ImageIcon("images/img/메인_좌측1.png"), new ImageIcon("images/img/메인_좌측2.png"),
				new ImageIcon("images/img/메인_좌측3.png"), new ImageIcon("images/img/메인_좌측4.png"),
				new ImageIcon("images/img/메인_좌측5.png") };
		expenditureIcon = new JButton(new ImageIcon("images/img/메인_좌측1.png"));
		expenditureIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
		expenditureIcon.setMaximumSize(new Dimension(87, 112));
		expenditureIcon.setBackground(new Color(52, 73, 94));
		expenditureIcon.setBorder(BorderFactory.createLineBorder(new Color(52, 73, 94)));
		expenditureIcon.addActionListener(this);
		menuPanel.add(Box.createVerticalStrut(10)); // 간격 추가
		menuPanel.add(expenditureIcon);
		goalIcon = new JButton(new ImageIcon("images/img/메인_좌측2.png"));
		goalIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
		goalIcon.setMaximumSize(new Dimension(87, 112));
		goalIcon.setBackground(new Color(52, 73, 94));
		goalIcon.setBorder(BorderFactory.createLineBorder(new Color(52, 73, 94)));
		goalIcon.addActionListener(this);
		menuPanel.add(Box.createVerticalStrut(10)); // 간격 추가
		menuPanel.add(goalIcon);
		accountIcon = new JButton(new ImageIcon("images/img/메인_좌측3.png"));
		accountIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
		accountIcon.setMaximumSize(new Dimension(87, 112));
		accountIcon.setBackground(new Color(52, 73, 94));
		accountIcon.setBorder(BorderFactory.createLineBorder(new Color(52, 73, 94)));
		accountIcon.addActionListener(this);
		menuPanel.add(Box.createVerticalStrut(10)); // 간격 추가
		menuPanel.add(accountIcon);
		cardIcon = new JButton(new ImageIcon("images/img/메인_좌측4.png"));
		cardIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
		cardIcon.setMaximumSize(new Dimension(87, 112));
		cardIcon.setBackground(new Color(52, 73, 94));
		cardIcon.setBorder(BorderFactory.createLineBorder(new Color(52, 73, 94)));
		cardIcon.addActionListener(this);
		menuPanel.add(Box.createVerticalStrut(10)); // 간격 추가
		menuPanel.add(cardIcon);
		cashIcon = new JButton(new ImageIcon("images/img/메인_좌측5.png"));
		cashIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
		cashIcon.setMaximumSize(new Dimension(87, 112));
		cashIcon.setBackground(new Color(52, 73, 94));
		cashIcon.setBorder(BorderFactory.createLineBorder(new Color(52, 73, 94)));
		cashIcon.addActionListener(this);
		menuPanel.add(Box.createVerticalStrut(10)); // 간격 추가
		menuPanel.add(cashIcon);

        // JTabbedPane 생성
        JTabbedPane tabbedPane = new JTabbedPane();

        // 각 탭 추가
        //tabbedPane.addTab("지출 비교", ㅡㅁ());
        //tabbedPane.addTab("지출 조회", createExpenseDetailPanel());

        mainFrame.add(tabbedPane);
		
		// 메인 패널 지출관리
		//--------------------------------------------------------------------------------------
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBorder(new EmptyBorder(0, 10, 10, 10));
		// 상단 패널
		JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		topPanel.setPreferredSize(new Dimension(mainFrame.getWidth(), 50));
		topPanel.setBackground(Color.WHITE);

		// 년도 선택 및 버튼 추가
		JLabel yearLabel = new JLabel(new ImageIcon("images/img/메인_상단01.png"));
		yearLabel.setHorizontalAlignment(SwingConstants.CENTER);
		yearLabel.setPreferredSize(new Dimension(91, 43));
		JComboBox<String> yearComboBox = new JComboBox<>(new String[] { "2021", "2022", "2023" });
		yearComboBox.setPreferredSize(new Dimension(100, 43));
		JButton setupButton = new JButton(new ImageIcon("images/img/메인_상단02.png"));
		setupButton.setPreferredSize(new Dimension(95, 43));
		setupButton.setBackground(Color.WHITE);
		setupButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		setupButton.addActionListener(this);
		JButton newGoalButton = new JButton(new ImageIcon("images/img/메인_상단03.png"));
		newGoalButton.setSize(70, 43);
		newGoalButton.setPreferredSize(new Dimension(141, 43));
		newGoalButton.setBackground(Color.WHITE);
		newGoalButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		newGoalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ExpenseFrame ExpenseFrame =new ExpenseFrame(); // 새 창 열기
            }
        });
		JButton compareButton = new JButton(new ImageIcon("images/img/메인_상단04.png"));
		compareButton.setBounds(100, 0, 100, 43);
		compareButton.setPreferredSize(new Dimension(141, 43));
		compareButton.setBackground(Color.WHITE);
		compareButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		compareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ExpenseCompareFrame ExpenseCompareFrame = new ExpenseCompareFrame(); // 새 창 열기
            }
        });
		JButton detailButton = new JButton(new ImageIcon("images/img/메인_상단05.png"));
		detailButton.setSize(70, 43);
		detailButton.setPreferredSize(new Dimension(141, 43));
		detailButton.setBackground(Color.WHITE);
		detailButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		detailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ExpenseDetailFrame ExpenseDetailFrame =new ExpenseDetailFrame(); // 새 창 열기
            }
        });
		// 상단 버튼 추가
		topPanel.add(yearLabel);
		topPanel.add(yearComboBox);
		topPanel.add(setupButton);
		topPanel.add(newGoalButton);
		topPanel.add(compareButton);
		topPanel.add(detailButton);

		// 테이블 데이터
		String[] columnNames = { "분류명", "목표", "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월",
				"년간", "(%)" };
		Object[][] data = {
				{ "식료품", "1,000,000", "200,000", "150,000", "300,000", "400,000", "300,000", "500,000", "600,000",
						"700,000", "200,000", "300,000", "500,000", "600,000", "4,950,000", "28%" },
				{ "주거비", "500,000", "100,000", "150,000", "100,000", "100,000", "200,000", "300,000", "400,000",
						"300,000", "100,000", "200,000", "400,000", "400,000", "3,250,000", "18%" },
				{ "교통비", "100,000", "20,000", "30,000", "20,000", "20,000", "50,000", "60,000", "70,000", "50,000",
						"20,000", "30,000", "50,000", "50,000", "450,000", "4%" } };

		JTable table = new JTable(new DefaultTableModel(data, columnNames));
		JScrollPane tableScrollPane = new JScrollPane(table);
		tableScrollPane.setBackground(Color.white);
		tableScrollPane.setBorder(null);
		//tableScrollPane.setBorder(new EmptyBorder(0, 10, 0, 10));
		mainPanel.add(tableScrollPane, BorderLayout.CENTER);

		// 하단 요약 패널
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		bottomPanel.setBackground(Color.LIGHT_GRAY);
		//bottomPanel.setBorder(new EmptyBorder(0, 10, 10, 10));
		JLabel totalLabel = new JLabel("총계: 34,638,328");
		bottomPanel.add(totalLabel);
		
		// 메인 패널에 컴포넌트 추가
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);

		
		
		
		// 목표관리----------------------------------------------
		//--------------------------------------------------------------------------------------
		targetPanel = new JPanel(new BorderLayout());
		targetPanel.setBackground(Color.WHITE);
		targetPanel.setBorder(new EmptyBorder(0, 10, 10, 10));

		// 상단 패널
		JPanel targetTopPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		targetTopPanel.setPreferredSize(new Dimension(mainFrame.getWidth(), 50));
		targetTopPanel.setBackground(Color.WHITE);

		// 년도 선택 및 버튼 추가
		JLabel targetYearLabel = new JLabel(new ImageIcon("images/img/메인_상단01.png"));
		targetYearLabel.setHorizontalAlignment(SwingConstants.CENTER);
		targetYearLabel.setPreferredSize(new Dimension(91, 43));
		JComboBox<String> targetYearComboBox = new JComboBox<>(new String[] { "2021", "2022", "2023" });
		targetYearComboBox.setPreferredSize(new Dimension(100, 43));
		JButton targetNewGoalButton = new JButton(new ImageIcon("images/img/메인_상단02.png"));
		targetNewGoalButton.setPreferredSize(new Dimension(95, 43));
		targetNewGoalButton.setBackground(Color.WHITE);
		targetNewGoalButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
//			JButton setupButton = new JButton(new ImageIcon("images/img/메인_상단03.png"));
//			setupButton.setSize(70,43);
//			setupButton.setPreferredSize(new Dimension(141,43 ));
//			setupButton.setBackground(Color.WHITE);
//			setupButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
//			JButton compareButton = new JButton(new ImageIcon("images/img/메인_상단04.png"));
//			compareButton.setBounds(100,0,100,43);
//			compareButton.setPreferredSize(new Dimension(141,43 ));
//			compareButton.setBackground(Color.WHITE);
//			compareButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
//			JButton detailButton = new JButton(new ImageIcon("images/img/메인_상단05.png"));
//			detailButton.setSize(70,43);
//			detailButton.setPreferredSize(new Dimension(141,43 ));
//			detailButton.setBackground(Color.WHITE);
//			detailButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		// 상단 버튼 추가
		targetTopPanel.add(targetYearLabel);
		targetTopPanel.add(targetYearComboBox);
		targetTopPanel.add(targetNewGoalButton);
//		topPanel.add(setupButton);
//		topPanel.add(compareButton);
//		topPanel.add(detailButton);

		// 테이블 데이터
		String[] targetColumnNames = { "분류명", "목표", "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월",
				"12월", "년간", "(%)" };
		Object[][] targetData = {
				{ "식료품", "1,000,000", "200,000", "150,000", "300,000", "400,000", "300,000", "500,000", "600,000",
						"700,000", "200,000", "300,000", "500,000", "600,000", "4,950,000", "28%" },
				{ "주거비", "500,000", "100,000", "150,000", "100,000", "100,000", "200,000", "300,000", "400,000",
						"300,000", "100,000", "200,000", "400,000", "400,000", "3,250,000", "18%" },
				{ "교통비", "100,000", "20,000", "30,000", "20,000", "20,000", "50,000", "60,000", "70,000", "50,000",
						"20,000", "30,000", "50,000", "50,000", "450,000", "4%" } };

		JTable targetTable = new JTable(new DefaultTableModel(targetData, targetColumnNames));
		JScrollPane targetTableScrollPane = new JScrollPane(targetTable);
		targetPanel.add(targetTableScrollPane, BorderLayout.CENTER);

		// 하단 요약 패널
		JPanel targetBottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		targetBottomPanel.setBackground(Color.LIGHT_GRAY);
		JLabel targetTotalLabel = new JLabel("총계111: 34,638,328");
		targetBottomPanel.add(targetTotalLabel);

		// 메인 패널에 컴포넌트 추가
		targetPanel.add(targetTopPanel, BorderLayout.NORTH);
		targetPanel.add(targetBottomPanel, BorderLayout.SOUTH);

		
		
		
		// 전체 레이아웃 설정
		mainFrame.add(menuPanel, BorderLayout.WEST); // 메뉴를 상단으로 이동
		mainFrame.add(mainPanel, BorderLayout.CENTER);

		// 메인 창 표시
		mainFrame.setVisible(true);

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == expenditureIcon) {
	        mainPanel.setVisible(true);
	        targetPanel.setVisible(false);
			mainFrame.add(mainPanel, BorderLayout.CENTER);
		} else if (e.getSource() == goalIcon) {
	        mainPanel.setVisible(false);
	        targetPanel.setVisible(true);
			mainFrame.add(targetPanel, BorderLayout.CENTER);
		} else if (e.getSource() == accountIcon) {
			mainPanel.setVisible(false);
		} else if (e.getSource() == cardIcon) {
//	        p2.setVisible(false);
		} else if (e.getSource() == cashIcon) {
//	        p2.setVisible(false);
		} 
//		else if (e.getSource() == cashIcon) {
//	        openMainWindow(inputId);
//		}
		
	}
}
class ExpenseFrame extends JFrame {//지출기준 설
    public ExpenseFrame() {
        setTitle("지출 기준 설정");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(20, 30, 20, 30));
        add(panel);
        panel.setLayout(new BorderLayout());
        // 왼쪽 테이블 패널
        String[] columnNames = {"번호", "계정", "일자", "금액", "카드", "비고"};
        Object[][] data = {
                {"1", "운동활동", "10일", "200,000", "국민은행", "활동용돈"},
                {"2", "운동활동", "10일", "150,000", "국민은행", "김동용돈"},
                {"3", "운동부모", "10일", "200,000", "국민은행", "송정"},
                {"4", "운동부모", "10일", "100,000", "국민은행", "김해"}
        };

        JTable table = new JTable(new DefaultTableModel(data, columnNames));
        JScrollPane tableScrollPane = new JScrollPane(table);
        panel.add(tableScrollPane, BorderLayout.CENTER);
        tableScrollPane.setBackground(Color.WHITE);
        // 오른쪽 입력 패널
//        JPanel inputPanel = new JPanel();
//        inputPanel.setLayout(new GridLayout(6, 2, 10, 10));
//        inputPanel.setPreferredSize(new Dimension(300, getHeight()));
//
//        inputPanel.add(new JLabel("지출일자:"));
//        inputPanel.add(new JTextField("2021-11-19"));
//
//        inputPanel.add(new JLabel("지출계정:"));
//        inputPanel.add(new JComboBox<>(new String[]{"계정1", "계정2", "계정3"}));
//
//        inputPanel.add(new JLabel("신용카드:"));
//        inputPanel.add(new JComboBox<>(new String[]{"국민은행", "신한카드", "씨티카드"}));
//
//        inputPanel.add(new JLabel("지출금액:"));
//        inputPanel.add(new JTextField("0"));
//
//        inputPanel.add(new JLabel("비고:"));
//        inputPanel.add(new JTextField());
//
//        // 버튼 패널
//        JPanel buttonPanel = new JPanel(new FlowLayout());
//        JButton addButton = new JButton("+ 추가");
//        JButton resetButton = new JButton("초기화");
//        JButton editButton = new JButton("수정");
//        JButton deleteButton = new JButton("삭제");
//
//        buttonPanel.add(addButton);
//        buttonPanel.add(resetButton);
//        buttonPanel.add(editButton);
//        buttonPanel.add(deleteButton);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setPreferredSize(new Dimension(350, getHeight()));
        rightPanel.setBackground(new Color(240, 240, 240));
        rightPanel.setLayout(null); // 절대 위치 설정
        rightPanel.setBounds(500, 20, 250, 550); // (x, y, width, height)
        rightPanel.setBackground(new Color(240, 240, 240)); // 배경색 설정
 			//✅ 지출일자 (JLabel + JComboBox)
        ImageIcon btnDate = new ImageIcon("images/img/지출관리_01일자.png");
        Image btnDater = btnDate.getImage().getScaledInstance(80, 35, Image.SCALE_SMOOTH);
        ImageIcon btnDates = new ImageIcon(btnDater);
        JLabel dateLabel = new JLabel(btnDates);
        dateLabel.setBounds(20, 20, 80, 25);
        rightPanel.add(dateLabel);

        JComboBox<String> dateComboBox = new JComboBox<>(new String[]{"2021-11-19"});
        dateComboBox.setBounds(110, 20, 120, 25);
        rightPanel.add(dateComboBox);

        // ✅ 지출계정 (JLabel + JComboBox)
        ImageIcon btnAccount = new ImageIcon("images/img/지출관리_02계정.png");
        Image btnAccountr = btnAccount.getImage().getScaledInstance(80, 35, Image.SCALE_SMOOTH);
        ImageIcon btnAccounts = new ImageIcon(btnAccountr);
        JLabel accountLabel = new JLabel(btnAccounts);
        accountLabel.setBounds(20, 60, 80, 25);
        rightPanel.add(accountLabel);

        JComboBox<String> accountComboBox = new JComboBox<>(new String[]{"식료품", "교통비", "주거비"});
        accountComboBox.setBounds(110, 60, 120, 25);
        rightPanel.add(accountComboBox);

        // ✅ 신용카드 (JLabel + JComboBox)
        ImageIcon btnCard = new ImageIcon("images/img/지출관리_03신용.png");
        Image btnCardr = btnCard.getImage().getScaledInstance(80, 35, Image.SCALE_SMOOTH);
        ImageIcon btnCards = new ImageIcon(btnCardr);
        JLabel cardLabel = new JLabel(btnCards);
        cardLabel.setBounds(20, 100, 80, 25);
        rightPanel.add(cardLabel);

        JComboBox<String> cardComboBox = new JComboBox<>(new String[]{"국민은행", "신한카드", "씨티카드"});
        cardComboBox.setBounds(110, 100, 120, 25);
        rightPanel.add(cardComboBox);

        // ✅ 지출금액 (JLabel + JTextField)
        ImageIcon btnAmount = new ImageIcon("images/img/지출관리_04금액.png");
        Image btnAmountr = btnAmount.getImage().getScaledInstance(80, 35, Image.SCALE_SMOOTH);
        ImageIcon btnAmounts = new ImageIcon(btnAmountr);
        JLabel amountLabel = new JLabel(btnAmounts);
        amountLabel.setBounds(20, 140, 80, 25);
        rightPanel.add(amountLabel);

        JTextField amountField = new JTextField("0");
        amountField.setBounds(110, 140, 120, 25);
        rightPanel.add(amountField);

        // ✅ 비고 (JLabel + JTextField)
        ImageIcon btnNote = new ImageIcon("images/img/지출관리_05비고.png");
        Image btnNoter = btnNote.getImage().getScaledInstance(80, 35, Image.SCALE_SMOOTH);
        ImageIcon btnNotes = new ImageIcon(btnNoter);
        JLabel noteLabel = new JLabel(btnNotes);
        noteLabel.setBounds(20, 180, 80, 25);
        rightPanel.add(noteLabel);

        JTextField noteField = new JTextField();
        noteField.setBounds(110, 180, 120, 25);
        rightPanel.add(noteField);

        // ✅ 버튼들 (추가, 초기화, 수정, 삭제)
        ImageIcon btnAdd = new ImageIcon("images/img/지출관리_06추가.png");
        Image btnAddr = btnAdd.getImage().getScaledInstance(80, 35, Image.SCALE_SMOOTH);
        ImageIcon btnAdds = new ImageIcon(btnAddr);
        JButton addButton = new JButton(btnAdds);
        addButton.setBounds(20, 230, 80, 35);
        addButton.setPreferredSize(new Dimension(80, 35));
        rightPanel.add(addButton);
        
        ImageIcon btnReset = new ImageIcon("images/img/지출관리_07초기화.png");
        Image btnResetr = btnReset.getImage().getScaledInstance(60, 35, Image.SCALE_SMOOTH);
        ImageIcon btnResets = new ImageIcon(btnResetr);
        JButton resetButton = new JButton(btnResets);
        resetButton.setBounds(110, 230, 60, 35);
        rightPanel.add(resetButton);

        ImageIcon btnUpdate = new ImageIcon("images/img/지출관리_07수정.png");
        Image btnUpdater = btnUpdate.getImage().getScaledInstance(60, 35, Image.SCALE_SMOOTH);
        ImageIcon btnUpdates = new ImageIcon(btnUpdater);
        JButton updateButton = new JButton(btnUpdates);
        updateButton.setBounds(180, 230, 60, 35);
        rightPanel.add(updateButton);

        JButton deleteButton = new JButton(new ImageIcon("images/img/지출관리_08삭제.png"));
        deleteButton.setBounds(250, 230, 60, 35);
        rightPanel.add(deleteButton);

        panel.add(rightPanel, BorderLayout.EAST);
        
        setVisible(true);
    }
}

class ExpenseCompareFrame extends JFrame {
    public ExpenseCompareFrame() {
    	setTitle("지출 비교 분석");
    	setSize(900, 600);
    	setLocationRelativeTo(null);
    	JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(20, 30, 20, 30));
        add(panel);
        panel.setLayout(new BorderLayout());
        // 상단 패널 (년월 선택 + 검색 버튼)
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton homeButton = new JButton("🏠");
        JComboBox<String> yearMonthSelect = new JComboBox<>(new String[]{"2021.10", "2021.09", "2021.08"});
        JButton searchButton = new JButton("검색");

        topPanel.add(homeButton);
        topPanel.add(new JLabel("년월 선택"));
        topPanel.add(yearMonthSelect);
        topPanel.add(searchButton);

        panel.add(topPanel, BorderLayout.NORTH);

        // 테이블 데이터
        String[] columnNames = {"지출계정", "지출금액", "목표금액", "목표대비", "전월금액", "전년동월"};
        Object[][] data = {
                {"식료품", 778730, 700000, "111%", 889110, 868905},
                {"주거비", 458681, 470000, "97%", 473015, 503619},
                {"교통비", 55150, 60000, "91%", 65500, 50000},
                {"문화비", 37682, 50000, "75%", 131322, 97303},
                {"통신비", 176900, 160000, "110%", 176900, 166000},
                {"의료비", 112895, 100000, "112%", 162930, 165070},
                {"차량유지", 27650, 30000, "92%", 376010, 135820},
                {"보험료", 109440, 110000, "99%", 146320, 109440},
                {"의류비", 158200, 150000, "105%", 151303, 0},
                {"여행비", 197410, 200000, "98%", 113640, 96200}
        };

        JTable table = new JTable(new DefaultTableModel(data, columnNames));
        JScrollPane tableScrollPane = new JScrollPane(table);
        panel.add(tableScrollPane, BorderLayout.CENTER);

        // 하단 총합 패널
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 6));
        bottomPanel.add(new JLabel("합계"));
        bottomPanel.add(new JLabel("3,409,148"));
        bottomPanel.add(new JLabel("3,330,000"));
        bottomPanel.add(new JLabel("102%"));
        bottomPanel.add(new JLabel("3,976,351"));
        bottomPanel.add(new JLabel("3,487,669"));

        panel.add(bottomPanel, BorderLayout.SOUTH);

       setVisible(true);
    }
}

class ExpenseDetailFrame extends JFrame {
    public ExpenseDetailFrame() {
        setTitle("지출 상세 조회");
        setSize(1000, 600);
        setLocationRelativeTo(null);
    	JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(20, 30, 20, 30));
        add(panel);
        panel.setLayout(new BorderLayout());

        // 왼쪽 패널 (검색 필터) leftPanel인데 귀찮다 위에걸 따르자
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setPreferredSize(new Dimension(350, getHeight()));
        rightPanel.setBackground(new Color(240, 240, 240));
        rightPanel.setLayout(null); // 절대 위치 설정
        rightPanel.setBounds(500, 20, 250, 550); // (x, y, width, height)
        rightPanel.setBackground(new Color(240, 240, 240)); // 배경색 설정
 			//✅ 지출일자 (JLabel + JComboBox)
        ImageIcon btnDate = new ImageIcon("images/img/지출조회_01시작.png");
        Image btnDater = btnDate.getImage().getScaledInstance(80, 35, Image.SCALE_SMOOTH);
        ImageIcon btnDates = new ImageIcon(btnDater);
        JLabel dateLabel = new JLabel(btnDates);
        dateLabel.setBounds(20, 20, 80, 25);
        rightPanel.add(dateLabel);

        JComboBox<String> dateComboBox = new JComboBox<>(new String[]{"2021-11-19"});
        dateComboBox.setBounds(110, 20, 120, 25);
        rightPanel.add(dateComboBox);

        // ✅ 지출계정 (JLabel + JComboBox)
        ImageIcon btnAccount = new ImageIcon("images/img/지출조회_02종료.png");
        Image btnAccountr = btnAccount.getImage().getScaledInstance(80, 35, Image.SCALE_SMOOTH);
        ImageIcon btnAccounts = new ImageIcon(btnAccountr);
        JLabel accountLabel = new JLabel(btnAccounts);
        accountLabel.setBounds(20, 60, 80, 25);
        rightPanel.add(accountLabel);

        JComboBox<String> accountComboBox = new JComboBox<>(new String[]{"식료품", "교통비", "주거비"});
        accountComboBox.setBounds(110, 60, 120, 25);
        rightPanel.add(accountComboBox);

        // ✅ 신용카드 (JLabel + JComboBox)
        ImageIcon btnCard = new ImageIcon("images/img/지출조회_03신용.png");
        Image btnCardr = btnCard.getImage().getScaledInstance(80, 35, Image.SCALE_SMOOTH);
        ImageIcon btnCards = new ImageIcon(btnCardr);
        JLabel cardLabel = new JLabel(btnCards);
        cardLabel.setBounds(20, 100, 80, 25);
        rightPanel.add(cardLabel);

        JComboBox<String> cardComboBox = new JComboBox<>(new String[]{"국민은행", "신한카드", "씨티카드"});
        cardComboBox.setBounds(110, 100, 120, 25);
        rightPanel.add(cardComboBox);

        // ✅ 지출금액 (JLabel + JTextField)
        ImageIcon btnAmount = new ImageIcon("images/img/지출조회_04금액.png");
        Image btnAmountr = btnAmount.getImage().getScaledInstance(80, 35, Image.SCALE_SMOOTH);
        ImageIcon btnAmounts = new ImageIcon(btnAmountr);
        JLabel amountLabel = new JLabel(btnAmounts);
        amountLabel.setBounds(20, 140, 80, 25);
        rightPanel.add(amountLabel);

        JTextField amountField = new JTextField("0");
        amountField.setBounds(110, 140, 120, 25);
        rightPanel.add(amountField);
        
     // ✅ 비고 (JLabel + JTextField)
        ImageIcon btnNote = new ImageIcon("images/img/지출조회_05비고.png");
        Image btnNoter = btnNote.getImage().getScaledInstance(80, 35, Image.SCALE_SMOOTH);
        ImageIcon btnNotes = new ImageIcon(btnNoter);
        JLabel noteLabel = new JLabel(btnNotes);
        noteLabel.setBounds(20, 180, 80, 25);
        rightPanel.add(noteLabel);

        JTextField noteField = new JTextField();
        noteField.setBounds(110, 180, 120, 25);
        rightPanel.add(noteField);

        // ✅ 버튼들 (추가, 초기화, 수정, 삭제)
        ImageIcon btnReset = new ImageIcon("images/img/지출조회_06검색.png");
        Image btnResetr = btnReset.getImage().getScaledInstance(240, 35, Image.SCALE_SMOOTH);
        ImageIcon btnResets = new ImageIcon(btnResetr);
        JButton resetButton = new JButton(btnResets);
        resetButton.setBounds(20, 230, 240, 35);
        rightPanel.add(resetButton);
        
        
        ImageIcon btnAdd = new ImageIcon("images/img/지출조회_07합계.png");
        Image btnAddr = btnAdd.getImage().getScaledInstance(80, 35, Image.SCALE_SMOOTH);
        ImageIcon btnAdds = new ImageIcon(btnAddr);
        JButton addButton = new JButton(btnAdds);
        addButton.setBounds(20, 350, 80, 35);
        addButton.setPreferredSize(new Dimension(80, 35));
        rightPanel.add(addButton);
        

        JLabel totalAmountLabel = new JLabel("828,012");
        totalAmountLabel.setForeground(Color.RED);
        totalAmountLabel.setBounds(110, 350, 120, 35);
        totalAmountLabel.setFont(new Font("Arial", Font.BOLD, 20));
        rightPanel.add(totalAmountLabel);
        panel.add(rightPanel, BorderLayout.WEST);

        // 테이블 데이터
        String[] columnNames = {"일자", "계정", "금액", "카드", "비고"};
        Object[][] data = {
                {"2021-11-02", "식료품", "3,000", "씨티카드", "진네이버역"},
                {"2021-11-02", "식료품", "3,500", "씨티카드", "맥도날드 양재 SK DT점"},
                {"2021-10-31", "모임회비", "20,000", "국민은행", "양꼬치"},
                {"2021-10-31", "모임회비", "40,000", "국민은행", "등기계비"},
                {"2021-10-31", "모임회비", "20,000", "국민은행", "김돌계비"},
                {"2021-10-31", "주거비", "164,110", "국민은행", "관리비"},
                {"2021-10-31", "용돈출빽", "200,000", "국민은행", "방과후"},
                {"2021-10-31", "의류비", "-50,000", "국민은행", "철학박박 부담금"}
        };

        JTable table = new JTable(new DefaultTableModel(data, columnNames));
        JScrollPane tableScrollPane = new JScrollPane(table);
        panel.add(tableScrollPane, BorderLayout.CENTER);


        setVisible(true);
    }
}
//열심히 하기 위해서 기초를 닦는다.

//늦고 안늦고의 문제가 아니라 해야하는 일이야
//늦었든 빠르든 해야한다고 앞으로의 과제라고