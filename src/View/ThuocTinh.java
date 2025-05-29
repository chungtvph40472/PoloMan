package View;

import Repository.ChatLieuRepository;
import Repository.KichThuocRepository;
import Repository.MauSacRepository;
import Response.ChatLieuResponse;
import Response.KichThuocResponse;
import Response.MauSacResponse;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ThuocTinh extends javax.swing.JFrame {

    private DefaultTableModel dtmMauSac;
    private DefaultTableModel dtmKichThuoc;
    private DefaultTableModel dtmChatLieu;
    private ArrayList<MauSacResponse> list_mau = new ArrayList<>();
    private ArrayList<ChatLieuResponse> list_cl = new ArrayList<>();
    private ArrayList<KichThuocResponse> list_kt = new ArrayList<>();
    private MauSacRepository mauSacRepo;
    private KichThuocRepository kichThuocRepo;
    private ChatLieuRepository chatLieuRepo;
    private int index = 0;

    /**
     * Creates new form ThuocTInhSP
     */
    public ThuocTinh() {
        initComponents();
        setLocationRelativeTo(null);
        dtmMauSac = (DefaultTableModel) this.tblMauSac.getModel();
        dtmKichThuoc = (DefaultTableModel) this.tblKichThuoc.getModel();
        dtmChatLieu = (DefaultTableModel) this.tblChatLieu.getModel();
        mauSacRepo = new MauSacRepository();
        kichThuocRepo = new KichThuocRepository();
        chatLieuRepo = new ChatLieuRepository();
        list_cl = (ArrayList<ChatLieuResponse>) chatLieuRepo.getAll();
        list_kt = (ArrayList<KichThuocResponse>) kichThuocRepo.getAll();
        list_mau = (ArrayList<MauSacResponse>) mauSacRepo.getAll();
        fillToTableMauSac(list_mau);
        fillToTableKichThuoc(list_kt);
        fillToTableChatLieu(list_cl);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        panMau = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTenMau = new javax.swing.JTextField();
        rdoHetMauSac = new javax.swing.JRadioButton();
        rdoConMauSac = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        btnThemMau = new javax.swing.JButton();
        btnSuaMau = new javax.swing.JButton();
        btnXoaMau = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMauSac = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtTimMauSac = new javax.swing.JTextField();
        panChatLieu = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTenChatLieu = new javax.swing.JTextField();
        rdoHetChatLieu = new javax.swing.JRadioButton();
        rdoConChatLieu = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        btnThemChatLieu = new javax.swing.JButton();
        btnSuaChatLieu = new javax.swing.JButton();
        btnXoaChatLieu = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblChatLieu = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtTimChatLieu = new javax.swing.JTextField();
        panKichThuoc = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtKichThuoc = new javax.swing.JTextField();
        rdoHetKichThuoc = new javax.swing.JRadioButton();
        rdoConKichThuoc = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        btnThemKichThuoc = new javax.swing.JButton();
        btnSuaKichThuoc = new javax.swing.JButton();
        btnXoaKichThuoc = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblKichThuoc = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtTimKichThuoc = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 500));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(900, 500));

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        panMau.setBackground(new java.awt.Color(128, 203, 196));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tên Màu Sắc");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Trạng Thái");

        txtTenMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenMauActionPerformed(evt);
            }
        });

        buttonGroup7.add(rdoHetMauSac);
        rdoHetMauSac.setText("Hết hàng");

        buttonGroup7.add(rdoConMauSac);
        rdoConMauSac.setText("Còn hàng");
        rdoConMauSac.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        btnThemMau.setBackground(new java.awt.Color(0, 153, 255));
        btnThemMau.setForeground(new java.awt.Color(255, 255, 255));
        btnThemMau.setText("Thêm");

        btnSuaMau.setBackground(new java.awt.Color(255, 255, 0));
        btnSuaMau.setText("Sửa");

        btnXoaMau.setBackground(new java.awt.Color(255, 0, 0));
        btnXoaMau.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaMau.setText("Xóa");
        btnXoaMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaMauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoaMau)
                    .addComponent(btnSuaMau)
                    .addComponent(btnThemMau))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnSuaMau, btnThemMau, btnXoaMau});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemMau)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSuaMau)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoaMau, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSuaMau, btnThemMau, btnXoaMau});

        tblMauSac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Màu", "Tên Màu", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMauSac.setRowHeight(25);
        tblMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMauSacMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMauSac);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tìm Kiếm");

        javax.swing.GroupLayout panMauLayout = new javax.swing.GroupLayout(panMau);
        panMau.setLayout(panMauLayout);
        panMauLayout.setHorizontalGroup(
            panMauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMauLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panMauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panMauLayout.createSequentialGroup()
                        .addGroup(panMauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panMauLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTimMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panMauLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoHetMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rdoConMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panMauLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTenMau, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addGap(25, 25, 25))
        );

        panMauLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3});

        panMauLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtTenMau, txtTimMauSac});

        panMauLayout.setVerticalGroup(
            panMauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMauLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panMauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panMauLayout.createSequentialGroup()
                        .addGroup(panMauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTimMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panMauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenMau, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panMauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(rdoHetMauSac)
                            .addComponent(rdoConMauSac))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panMauLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        panMauLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, rdoConMauSac, rdoHetMauSac});

        panMauLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtTenMau, txtTimMauSac});

        jTabbedPane2.addTab("Màu Sắc", panMau);

        panChatLieu.setBackground(new java.awt.Color(128, 203, 196));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Tên Chất Liệu");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Trạng Thái");

        txtTenChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenChatLieuActionPerformed(evt);
            }
        });

        buttonGroup6.add(rdoHetChatLieu);
        rdoHetChatLieu.setText("Hết hàng");

        buttonGroup6.add(rdoConChatLieu);
        rdoConChatLieu.setText("Còn hàng");
        rdoConChatLieu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        btnThemChatLieu.setBackground(new java.awt.Color(0, 153, 255));
        btnThemChatLieu.setForeground(new java.awt.Color(255, 255, 255));
        btnThemChatLieu.setText("Thêm");

        btnSuaChatLieu.setBackground(new java.awt.Color(255, 255, 0));
        btnSuaChatLieu.setText("Sửa");

        btnXoaChatLieu.setBackground(new java.awt.Color(255, 0, 0));
        btnXoaChatLieu.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaChatLieu.setText("Xóa");
        btnXoaChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaChatLieuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoaChatLieu)
                    .addComponent(btnSuaChatLieu)
                    .addComponent(btnThemChatLieu))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnSuaChatLieu, btnThemChatLieu, btnXoaChatLieu});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemChatLieu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSuaChatLieu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSuaChatLieu, btnThemChatLieu, btnXoaChatLieu});

        tblChatLieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Chất Liệu", "Tên Chất Liệu", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblChatLieu.setRowHeight(25);
        tblChatLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChatLieuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblChatLieu);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Tìm Kiếm");

        javax.swing.GroupLayout panChatLieuLayout = new javax.swing.GroupLayout(panChatLieu);
        panChatLieu.setLayout(panChatLieuLayout);
        panChatLieuLayout.setHorizontalGroup(
            panChatLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panChatLieuLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panChatLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(panChatLieuLayout.createSequentialGroup()
                        .addGroup(panChatLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panChatLieuLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoHetChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(rdoConChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panChatLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(panChatLieuLayout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTimChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panChatLieuLayout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTenChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addGap(25, 25, 25))
        );

        panChatLieuLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel4, jLabel5, jLabel6});

        panChatLieuLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtTenChatLieu, txtTimChatLieu});

        panChatLieuLayout.setVerticalGroup(
            panChatLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panChatLieuLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panChatLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panChatLieuLayout.createSequentialGroup()
                        .addGroup(panChatLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTimChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panChatLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panChatLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(rdoHetChatLieu)
                            .addComponent(rdoConChatLieu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panChatLieuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        panChatLieuLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel4, jLabel5, jLabel6, rdoConChatLieu, rdoHetChatLieu});

        panChatLieuLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtTenChatLieu, txtTimChatLieu});

        jTabbedPane2.addTab("Chất Liệu", panChatLieu);

        panKichThuoc.setBackground(new java.awt.Color(128, 203, 196));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Tên Kích Cỡ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Trạng Thái");

        txtKichThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKichThuocActionPerformed(evt);
            }
        });

        buttonGroup5.add(rdoHetKichThuoc);
        rdoHetKichThuoc.setText("Hết hàng");

        buttonGroup5.add(rdoConKichThuoc);
        rdoConKichThuoc.setText("Còn hàng");
        rdoConKichThuoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        btnThemKichThuoc.setBackground(new java.awt.Color(0, 153, 255));
        btnThemKichThuoc.setForeground(new java.awt.Color(255, 255, 255));
        btnThemKichThuoc.setText("Thêm");

        btnSuaKichThuoc.setBackground(new java.awt.Color(255, 255, 0));
        btnSuaKichThuoc.setText("Sửa");

        btnXoaKichThuoc.setBackground(new java.awt.Color(255, 0, 0));
        btnXoaKichThuoc.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaKichThuoc.setText("Xóa");
        btnXoaKichThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKichThuocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoaKichThuoc)
                    .addComponent(btnSuaKichThuoc)
                    .addComponent(btnThemKichThuoc))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnSuaKichThuoc, btnThemKichThuoc, btnXoaKichThuoc});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemKichThuoc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSuaKichThuoc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSuaKichThuoc, btnThemKichThuoc, btnXoaKichThuoc});

        tblKichThuoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Kích Thước", "Tên Kích Thước", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKichThuoc.setRowHeight(25);
        tblKichThuoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKichThuocMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblKichThuoc);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Tìm Kiếm");

        txtTimKichThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKichThuocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panKichThuocLayout = new javax.swing.GroupLayout(panKichThuoc);
        panKichThuoc.setLayout(panKichThuocLayout);
        panKichThuocLayout.setHorizontalGroup(
            panKichThuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panKichThuocLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panKichThuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(panKichThuocLayout.createSequentialGroup()
                        .addGroup(panKichThuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panKichThuocLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoHetKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(rdoConKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panKichThuocLayout.createSequentialGroup()
                                .addGroup(panKichThuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panKichThuocLayout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTimKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panKichThuocLayout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addGap(25, 25, 25))
        );

        panKichThuocLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel7, jLabel8, jLabel9});

        panKichThuocLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtKichThuoc, txtTimKichThuoc});

        panKichThuocLayout.setVerticalGroup(
            panKichThuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panKichThuocLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panKichThuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panKichThuocLayout.createSequentialGroup()
                        .addGroup(panKichThuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTimKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panKichThuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panKichThuocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(rdoHetKichThuoc)
                            .addComponent(rdoConKichThuoc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panKichThuocLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        panKichThuocLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel7, jLabel8, jLabel9, rdoConKichThuoc, rdoHetKichThuoc});

        panKichThuocLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtKichThuoc, txtTimKichThuoc});

        jTabbedPane2.addTab("Kích Thước", panKichThuoc);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 803, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaMauActionPerformed

    }//GEN-LAST:event_btnXoaMauActionPerformed

    private void txtTenMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenMauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenMauActionPerformed

    private void txtTenChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenChatLieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenChatLieuActionPerformed

    private void btnXoaChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaChatLieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaChatLieuActionPerformed

    private void txtKichThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKichThuocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKichThuocActionPerformed

    private void btnXoaKichThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKichThuocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaKichThuocActionPerformed

    private void txtTimKichThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKichThuocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKichThuocActionPerformed

    private void tblMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMauSacMouseClicked
        try {
            int row = tblMauSac.getSelectedRow();
            if (row == -1) {
                return;
            }
            MauSacResponse ms = mauSacRepo.getAll().get(row);
            txtTenMau.setText(ms.getTenMauSac());
            boolean trangThai = ms.getTrangThai() == 1; // true = còn hàng, false = hết hàng
            rdoConMauSac.setSelected(trangThai);
            rdoHetMauSac.setSelected(!trangThai);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblMauSacMouseClicked

    private void tblChatLieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChatLieuMouseClicked
        try {
            int row = tblChatLieu.getSelectedRow();
            if (row == -1) {
                return;
            }
            ChatLieuResponse cl = chatLieuRepo.getAll().get(row);
            txtTenChatLieu.setText(cl.getTenChatLieu());
            boolean trangThai = cl.getTrangThai() == 1; // true = còn hàng, false = hết hàng
            rdoConChatLieu.setSelected(trangThai);
            rdoHetChatLieu.setSelected(!trangThai);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblChatLieuMouseClicked

    private void tblKichThuocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKichThuocMouseClicked
         try {
            int row = tblKichThuoc.getSelectedRow();
            if (row == -1) {
                return;
            }
            KichThuocResponse kt = kichThuocRepo.getAll().get(row);
            txtKichThuoc.setText(kt.getTenKichThuoc());
            boolean trangThai = kt.getTrangThai() == 1; // true = còn hàng, false = hết hàng
            rdoConKichThuoc.setSelected(trangThai);
            rdoHetKichThuoc .setSelected(!trangThai);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblKichThuocMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThuocTinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThuocTinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThuocTinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThuocTinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThuocTinh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaChatLieu;
    private javax.swing.JButton btnSuaKichThuoc;
    private javax.swing.JButton btnSuaMau;
    private javax.swing.JButton btnThemChatLieu;
    private javax.swing.JButton btnThemKichThuoc;
    private javax.swing.JButton btnThemMau;
    private javax.swing.JButton btnXoaChatLieu;
    private javax.swing.JButton btnXoaKichThuoc;
    private javax.swing.JButton btnXoaMau;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JPanel panChatLieu;
    private javax.swing.JPanel panKichThuoc;
    private javax.swing.JPanel panMau;
    private javax.swing.JRadioButton rdoConChatLieu;
    private javax.swing.JRadioButton rdoConKichThuoc;
    private javax.swing.JRadioButton rdoConMauSac;
    private javax.swing.JRadioButton rdoHetChatLieu;
    private javax.swing.JRadioButton rdoHetKichThuoc;
    private javax.swing.JRadioButton rdoHetMauSac;
    private javax.swing.JTable tblChatLieu;
    private javax.swing.JTable tblKichThuoc;
    private javax.swing.JTable tblMauSac;
    private javax.swing.JTextField txtKichThuoc;
    private javax.swing.JTextField txtTenChatLieu;
    private javax.swing.JTextField txtTenMau;
    private javax.swing.JTextField txtTimChatLieu;
    private javax.swing.JTextField txtTimKichThuoc;
    private javax.swing.JTextField txtTimMauSac;
    // End of variables declaration//GEN-END:variables

    private void fillToTableMauSac(ArrayList<MauSacResponse> list_mau) {
        dtmMauSac.setRowCount(0);
        index = 1;
        for (MauSacResponse ms : list_mau) {
            dtmMauSac.addRow(new Object[]{
                index++,
                ms.getMaMauSac(),
                ms.getTenMauSac(),
                ms.getTrangThai() == 1 ? "Còn hàng" : "Hết hàng"
            });
        }
    }

    private void fillToTableKichThuoc(ArrayList<KichThuocResponse> list_kt) {
        dtmKichThuoc.setRowCount(0);
        index = 1;
        for (KichThuocResponse kt : list_kt) {
            dtmKichThuoc.addRow(new Object[]{
                index++,
                kt.getMaKichThuoc(),
                kt.getTenKichThuoc(),
                kt.getTrangThai() == 1 ? "Còn hàng" : "Hết hàng"
            });
        }
    }

    private void fillToTableChatLieu(ArrayList<ChatLieuResponse> list_cl) {
        dtmChatLieu.setRowCount(0);
        index = 1;
        for (ChatLieuResponse cl : list_cl) {
            dtmChatLieu.addRow(new Object[]{
                index++,
                cl.getMaChatLieu(),
                cl.getTenChatLieu(),
                cl.getTrangThai() == 1 ? "Còn hàng" : "Hết hàng"
            });
        }
    }
}
