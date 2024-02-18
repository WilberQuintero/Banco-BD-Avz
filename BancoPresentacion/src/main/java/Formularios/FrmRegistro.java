/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formularios;

import Controlador.ControladorNegocio;
import Excepciones.PersistenciaException;
import com.toedter.calendar.JDateChooser;
import dao.ClienteDAO;
import dao.DireccionDAO;
import dao.UsuarioDAO;
import dto.ClienteDTO;
import dto.CuentaDTO;
import dto.DireccionDTO;
import dto.UsuarioDTO;
import entidadesdominio.Usuario;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class FrmRegistro extends javax.swing.JFrame {

    ControladorNegocio controlador = new ControladorNegocio();

    /**
     * Creates new form FmrRegistro
     */
    public FrmRegistro() {
        initComponents();
        //Hace que la ventana aparezca en medio
        setLocationRelativeTo(null);
      
    }

    public String convertirFecha(Date fecha) {
        Date fechaActual = JCFechaNac.getDate();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        // Convertir la fecha a una cadena con el formato especificado
        String fechaS = formatoFecha.format(fechaActual);

        return fechaS;

    }

    public boolean validarContra(String contra, int longitudMaxima, int longitudMinima) {
        // Verificar si la cadena es nula o vacía
        if (contra == null || contra.isEmpty()) {
            return false;
        }
        
        // Verificar la longitud de la cadena
        if (contra.length() > longitudMaxima || contra.length()< longitudMinima) {
            return false;
        }
        
        // Verificar que la contraseña exista en la base de datos
        if (contra != contra) {
            return false;
        }
        
        
        // La cadena cumple con los criterios de validación
        return true;
    }
    
    public boolean validarCampos(String nombreUsua, String nombre, String aP, String fechaNac, String contra, 
            String calle, String numCasa, String colonea){
        if (nombreUsua == null || nombreUsua.isEmpty() && nombre == null || nombre.isEmpty() && 
                aP == null || aP.isEmpty() && fechaNac == null || fechaNac.isEmpty() &&
                contra == null || contra.isEmpty() && calle == null || calle.isEmpty() &&
                numCasa == null || numCasa.isEmpty() && colonea == null || colonea.isEmpty()){
            JOptionPane.showMessageDialog(null, "Apellido Materno solo puede estar vacio...");
            return false;
        }
        
        if(contra.length() > 16 || contra.length() < 6){
        JOptionPane.showMessageDialog(null, "La contraseña tiene que ser mayor a 6 y menor a 16.");
        return false;
    }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCalle = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNumeroCasa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtColonia = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtAP = new javax.swing.JTextField();
        JCFechaNac = new com.toedter.calendar.JDateChooser();
        txtAM = new javax.swing.JTextField();
        txtNombreUsuario = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtContra = new javax.swing.JPasswordField();
        btnAceptar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro");

        jPanel2.setBackground(new java.awt.Color(229, 246, 246));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Datos Personales:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setText("Registro");

        jLabel6.setText("Calle:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel11.setText("No dejar ningún campo vacío");

        jLabel7.setText("Numero de casa:");

        jLabel2.setText("Nombre:");

        jLabel8.setText("Colonia:");

        jLabel3.setText("Apellido Paterno:");

        txtCalle.setBackground(new java.awt.Color(227, 236, 236));
        txtCalle.setToolTipText("");
        txtCalle.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtCalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCalleKeyTyped(evt);
            }
        });

        jLabel4.setText("Apellido Materno:");

        txtNumeroCasa.setBackground(new java.awt.Color(227, 236, 236));
        txtNumeroCasa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroCasaKeyTyped(evt);
            }
        });

        jLabel5.setText("Contraseña:");

        txtColonia.setBackground(new java.awt.Color(227, 236, 236));
        txtColonia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtColoniaKeyTyped(evt);
            }
        });

        txtNombre.setBackground(new java.awt.Color(227, 236, 236));
        txtNombre.setToolTipText("");
        txtNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel9.setText("Fecha de nacimiento:");

        txtAP.setBackground(new java.awt.Color(227, 236, 236));
        txtAP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAPKeyTyped(evt);
            }
        });

        JCFechaNac.setBackground(new java.awt.Color(227, 236, 236));
        JCFechaNac.setForeground(new java.awt.Color(227, 236, 236));

        txtAM.setBackground(new java.awt.Color(227, 236, 236));
        txtAM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAMKeyTyped(evt);
            }
        });

        txtNombreUsuario.setBackground(new java.awt.Color(227, 236, 236));
        txtNombreUsuario.setToolTipText("");
        txtNombreUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNombreUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreUsuarioKeyTyped(evt);
            }
        });

        jLabel10.setText("Nombre de usuario:");

        txtContra.setBackground(new java.awt.Color(227, 236, 236));
        txtContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraActionPerformed(evt);
            }
        });
        txtContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContraKeyTyped(evt);
            }
        });

        btnAceptar.setBackground(new java.awt.Color(175, 193, 210));
        btnAceptar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnRegresar.setBackground(new java.awt.Color(175, 193, 210));
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel13.setText("*6 digitos o mas*");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAP, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAM, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNumeroCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtCalle)
                                        .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JCFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(58, 58, 58)
                                        .addComponent(jLabel11))))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(JCFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumeroCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnRegresar))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        

        try {
            
            if(validarCampos(txtNombreUsuario.getText(), txtNombre.getText(), 
                    txtAP.getText(), JCFechaNac.getDateFormatString(), txtContra.getText(), 
                    txtCalle.getText(), txtNumeroCasa.getText(), txtColonia.getText()) == true){
          
            String contraEn = controlador.encriptar(txtContra.getText());
            controlador.agregarDirecYUsuaPrimeraVez(new DireccionDTO(txtCalle.getText(), txtColonia.getText(),
                    txtNumeroCasa.getText()),
                    new UsuarioDTO(txtNombreUsuario.getText(), contraEn));

            controlador.agregarCliente(new ClienteDTO(txtNombre.getText(), txtAP.getText(),
                    txtAM.getText(), this.convertirFecha(JCFechaNac.getDate()),
                    controlador.consultarIdUsuario(new UsuarioDTO(txtNombreUsuario.getText(),
                            contraEn)),
                    controlador.consultarIdDireccion(new DireccionDTO(txtCalle.getText(),
                            txtColonia.getText(), txtNumeroCasa.getText()))));

            controlador.agregarCuenta(new CuentaDTO(controlador.consultarIdCliente(new ClienteDTO(txtNombre.getText(),
                    txtAP.getText(), txtAM.getText(),
                    this.convertirFecha(JCFechaNac.getDate()),
                    controlador.consultarIdUsuario(new UsuarioDTO(txtNombreUsuario.getText(),
                            contraEn)),
                    controlador.consultarIdDireccion(new DireccionDTO(txtCalle.getText(),
                            txtColonia.getText(), txtNumeroCasa.getText()))))));
          
            
            FrmRegistroDeCuenta rcuenta = new FrmRegistroDeCuenta();
            rcuenta.setVisible(true);
            this.setVisible(false);
            }

        } catch (PersistenciaException ex) {
            Logger.getLogger(FrmRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        FrmIniciarSesion inicio = new FrmIniciarSesion();
        inicio.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraActionPerformed

    
    //METODOS PARA VALIDAR LONGITUD Y TIPO DE INSERT YA SEA NUMERO Y/O LETRA.
    private void txtNombreUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreUsuarioKeyTyped
        char c = evt.getKeyChar();

    // Verificar si la tecla presionada es el "backspace"
    if (c == '\b') {
        // No realizar ninguna acción especial para el "backspace"
        return;
    }

    // Verificar si el carácter no es una letra
    if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
        // Mostrar el mensaje de error solo si se está agregando un carácter
        JOptionPane.showMessageDialog(null, "Usuario solo acepta letras.");
        // Consumir el evento para evitar que el carácter se agregue
        evt.consume();
    }     //ESTE METODO VALIDA PARA QUE SOLO SE PUEDAN USAR LETRAS
    }//GEN-LAST:event_txtNombreUsuarioKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char c = evt.getKeyChar();

    // Verificar si la tecla presionada es el "backspace"
    if (c == '\b') {
        // No realizar ninguna acción especial para el "backspace"
        return;
    }

    // Verificar si el carácter no es una letra
    if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
        // Mostrar el mensaje de error solo si se está agregando un carácter
        JOptionPane.showMessageDialog(null, "Nombre solo acepta letras.");
        // Consumir el evento para evitar que el carácter se agregue
        evt.consume();
    }  
        //ESTE METODO VALIDA PARA QUE SOLO SE PUEDAN USAR LETRAS
     }//GEN-LAST:event_txtNombreKeyTyped

    private void txtAPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAPKeyTyped
        char c = evt.getKeyChar();

    // Verificar si la tecla presionada es el "backspace"
    if (c == '\b') {
        // No realizar ninguna acción especial para el "backspace"
        return;
    }

    // Verificar si el carácter no es una letra
    if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
        // Mostrar el mensaje de error solo si se está agregando un carácter
        JOptionPane.showMessageDialog(null, "Apellido Paterno solo acepta letras.");
        // Consumir el evento para evitar que el carácter se agregue
        evt.consume();
    }  
        //ESTE METODO VALIDA PARA QUE SOLO SE PUEDAN USAR LETRAS
    }//GEN-LAST:event_txtAPKeyTyped

    private void txtAMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAMKeyTyped
        char c = evt.getKeyChar();

    // Verificar si la tecla presionada es el "backspace"
    if (c == '\b') {
        // No realizar ninguna acción especial para el "backspace"
        return;
    }

    // Verificar si el carácter no es una letra
    if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
        // Mostrar el mensaje de error solo si se está agregando un carácter
        JOptionPane.showMessageDialog(null, "Apellido Materno solo acepta letras.");
        // Consumir el evento para evitar que el carácter se agregue
        evt.consume();
    }  
        //ESTE METODO VALIDA PARA QUE SOLO SE PUEDAN USAR LETRAS
    }//GEN-LAST:event_txtAMKeyTyped

    private void txtCalleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCalleKeyTyped
        char c = evt.getKeyChar();

    // Verificar si la tecla presionada es el "backspace"
    if (c == '\b') {
        // No realizar ninguna acción especial para el "backspace"
        return;
    }

    // Verificar si el carácter no es una letra
    if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9')) {
        // Mostrar el mensaje de error solo si se está agregando un carácter
        JOptionPane.showMessageDialog(null, "Calle solo acepta letras y numeros.");
        // Consumir el evento para evitar que el carácter se agregue
        evt.consume();
    }  
        //ESTE METODO VALIDA PARA QUE SOLO SE PUEDAN USAR LETRAS Y NUMEROS
    }//GEN-LAST:event_txtCalleKeyTyped

    private void txtNumeroCasaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroCasaKeyTyped
        char c = evt.getKeyChar();

    // Verificar si la tecla presionada es el "backspace"
    if (c == '\b') {
        // No realizar ninguna acción especial para el "backspace"
        return;
    }

    // Verificar si el carácter no es una letra
    if ((c < '0' || c > '9')) {
        // Mostrar el mensaje de error solo si se está agregando un carácter
        JOptionPane.showMessageDialog(null, "Numero de Casa solo acepta numeros.");
        // Consumir el evento para evitar que el carácter se agregue
        evt.consume();
    
    }//GEN-LAST:event_txtNumeroCasaKeyTyped
  }
    private void txtColoniaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtColoniaKeyTyped
        char c = evt.getKeyChar();

    // Verificar si la tecla presionada es el "backspace"
    if (c == '\b') {
        // No realizar ninguna acción especial para el "backspace"
        return;
    }

    // Verificar si el carácter no es una letra
    if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9')) {
        // Mostrar el mensaje de error solo si se está agregando un carácter
        JOptionPane.showMessageDialog(null, "Colonia solo acepta numeros.");
        // Consumir el evento para evitar que el carácter se agregue
        evt.consume();
    
    }
    
        //ESTE METODO VALIDA PARA QUE SOLO SE PUEDAN USAR LETRAS y NUMEROS
    }//GEN-LAST:event_txtColoniaKeyTyped

    private void txtContraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraKeyTyped
           char c = evt.getKeyChar();

    // Verificar si la tecla presionada es el "backspace"
    if (c == '\b') {
        // No realizar ninguna acción especial para el "backspace"
        return;
    }

    // Verificar si el carácter no es una letra
    if ((c >= 6 && c <= 16|| c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9')) {
        // Mostrar el mensaje de error solo si se está agregando un carácter
        JOptionPane.showMessageDialog(null, "Contraseña.");
        // Consumir el evento para evitar que el carácter se agregue
        evt.consume();
    
    }
           
           //ESTE METODO VALIDA PARA QUE ACEPTE DE 6 A 16 DIGITOS.

    }//GEN-LAST:event_txtContraKeyTyped

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JCFechaNac;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtAM;
    private javax.swing.JTextField txtAP;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JPasswordField txtContra;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtNumeroCasa;
    // End of variables declaration//GEN-END:variables
}
