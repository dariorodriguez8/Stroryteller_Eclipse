package laBuena;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class LectorCuentos extends JPanel {
    // princ pv = this.pv;
    JPanel decisiones;
    JPanel menu_siguiente;
    JPanel fin;
    int numeroPagina = 1;
    int subPagina = 0;
    char historiaParalela = 'A';
    String cuento;
    Icon icono;
    JLabel hoja=new JLabel();
    int numero = 0;
    JPanel pagina;
    JPanel empezar;
    private final Action action = new SwingAction();

    public LectorCuentos(String cuento, Cuento l) {
   

        setLayout(null);
        this.cuento = cuento;
        pagina = new JPanel();
        pagina.setBounds(0, 0, 768, 460);
        //pagina.setBackground(Color.);
        add(pagina);
        
        hoja.setBounds(0, 0, 768, 460);
        pagina.add(hoja);
        hoja.setIcon(new ImageIcon("C:\\Cuentos\\" + cuento + "\\portada.jpg"));

        decisiones = new JPanel();
        decisiones.setBounds(0, 460, 768, 140);
        add(decisiones);
        decisiones.setVisible(false);
        decisiones.setLayout(new GridLayout(0, 2, 0, 0));
            
        JButton btnA = new JButton("A");
        btnA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // System.out.println(gestionaCuento());
                /*
                 * icono= new ImageIcon(gestionaCuento()); hoja.setIcon(icono);
                 * pagina.add(hoja); pagina.updateUI(); historiaParalela = 'A';
                 */
                historiaParalela='A';
                numeroPagina++;
                gestionaCuento();
                
               
                
                /* gypsy mode
                numero++;
                hoja.setIcon(pantallas[numero]);
                hoja.setBounds(0, 0, 768, 460);
                pagina.add(hoja);
                if (numero == 0 || numero == 2 || numero == 3 || numero == 4
                        || numero == 6) {
                    setVisibleMenu();
                }
                ;
                if (numero == 1 || numero == 5) {
                    setVisibleDecision();
                }
                ;
                if (numero == 7) {
                    setVisibleFin();
                }
                ;
                hoja.updateUI();
                pagina.updateUI();*/
            }
        });
        btnA.setFont(new Font("Arial Black", Font.BOLD, 15));
        decisiones.add(btnA);

        JButton btnB = new JButton("B");
        btnB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                historiaParalela='B';
                numeroPagina++;
                gestionaCuento();
        
                /* gypsy mode
                numero++;

                hoja.setIcon(pantallas[numero]);
                hoja.setBounds(0, 0, 768, 460);
                pagina.add(hoja);
                if (numero == 0 || numero == 2 || numero == 3 || numero == 4
                        || numero == 6) {
                    setVisibleMenu();
                }
                ;
                if (numero == 1 || numero == 5) {
                    setVisibleDecision();
                }
                ;
                if (numero == 7) {
                    setVisibleFin();
                }
                ;
                hoja.updateUI();
                pagina.updateUI();
                 */
            }
        });
        btnB.setFont(new Font("Arial Black", Font.BOLD, 15));
        decisiones.add(btnB);

        menu_siguiente = new JPanel();
        menu_siguiente.setBounds(0, 460, 768, 140);
        add(menu_siguiente);
        menu_siguiente.setVisible(false);
        menu_siguiente.setLayout(new GridLayout(0, 1, 0, 0));

        JButton btnSiguiente = new JButton("Pasar pagina");
        btnSiguiente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /*
                 * icono= new ImageIcon(gestionaCuento());
                 * System.out.println("numero pagina y sub"
                 * +numeroPagina+"/"+subPagina+" cuento"+cuento);
                 * hoja.setIcon(icono); pagina.add(hoja); pagina.updateUI();
                 */
                gestionaCuento();
        
                /* gypsy mode
                numero++;
                hoja.setIcon(pantallas[numero]);
                hoja.setBounds(0, 0, 768, 460);
                pagina.add(hoja);

                if (numero == 0 || numero == 2 || numero == 3 || numero == 4
                        || numero == 6) {
                    setVisibleMenu();
                }
                ;
                if (numero == 1 || numero == 5) {
                    setVisibleDecision();
                }
                ;
                if (numero == 7) {
                    setVisibleFin();
                }
                ;
                hoja.updateUI();
                pagina.updateUI();
                System.out.println(hoja.getIcon().toString());
                System.out.println();
                */
            }
        });
        btnSiguiente.setFont(new Font("Arial Black", Font.BOLD, 15));
        menu_siguiente.add(btnSiguiente);
        fin = new JPanel();
        fin.setBounds(0, 460, 768, 140);
        fin.setLayout(new GridLayout(0, 1, 0, 0));
        add(fin);

        JButton btnFin = new JButton("Fin");
        btnFin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // vuelve a la pantalla de cuentos guardados
                l.dispose();
            }
        });
        fin.add(btnFin);
        
        empezar = new JPanel();
        empezar.setBounds(0, 460, 768, 140);
        add(empezar);
        empezar.setLayout(new GridLayout(1, 0, 0, 0));
        
        JButton empezarbtn = new JButton("Empezar");
        empezarbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gestionaCuento();
                setVisibleMenu();
                //subPagina=0;
            }
        });
        empezar.add(empezarbtn);
        empezar.setVisible(false);
        
        
        setVisibleEmpezar();

    }

    public void setVisibleDecision() {
        menu_siguiente.setVisible(false);
        decisiones.setVisible(true);
        fin.setVisible(false);
        empezar.setVisible(false);
        
    }

    public void setVisibleMenu() {
        menu_siguiente.setVisible(true);
        decisiones.setVisible(false);
        fin.setVisible(false);
        empezar.setVisible(false);
        
    }

    public void setVisibleFin() {
        menu_siguiente.setVisible(false);
        decisiones.setVisible(false);
        fin.setVisible(true);
        empezar.setVisible(false);
        
    }
    public void setVisibleEmpezar() {
        menu_siguiente.setVisible(false);
        decisiones.setVisible(false);
        fin.setVisible(false);
        empezar.setVisible(true);
        
    }
    private String gestionaCuento() {
        File d = new File("C:\\Cuentos\\" + cuento);
        String[] NumCuentos = d.list();
        if (d.exists()) {
            for (int i = 0; i < ((NumCuentos.length) - 2); i++) {
                File f = new File("C:\\Cuentos\\" + cuento + "\\"
                        + NumCuentos[i]);
                String[] subCuentos = f.list();
                
                System.out.println("longitud "+subCuentos.length);
                int historia;
                char prov = NumCuentos[i].charAt(1);
                if (prov=='_'){
                historia = Character.getNumericValue(NumCuentos[i].charAt(0));}
                else{
                String ninja = ""+NumCuentos[i].charAt(0)+prov;
                historia = Integer.parseInt(ninja);
                }
                char letra = NumCuentos[i].charAt(3);
                char tipoO = NumCuentos[i].charAt(5);
                // for(int h = 0; h < subCuentos.length; h++ ){

                System.out.println("num: " + historia + " letra: " + letra
                        + " tipo" + tipoO);
                if (numeroPagina == historia) {
                    System.out.println("yes");
                    if (letra == historiaParalela) {
                        System.out.println("ohhh yes");
                        if (tipoO == 'D') {
                            System.out.println("dd");
                            if (subPagina == (subCuentos.length-1)) {
                                
                                String fil = "C:\\Cuentos\\"+cuento+"\\"+ NumCuentos[i]
                                        + "\\" + subPagina + ".jpg";
                                
                                setVisibleDecision();
                                System.out.println(fil);
                                /*hoja.setIcon(fil);
                                hoja.setBounds(0, 0, 768, 460);
                                pagina.add(hoja);*/
                                
                                
                                //String imePath = "res/Image.png";
                                // ImageIcon icon = new ImageIcon(myImg);

                                // use icon here
                                System.out.println("Vaig a borrar hoja");
                                pagina.remove(hoja);
                                hoja=new JLabel();
                                hoja.setBounds(0, 0, 768, 460);
                                
                                hoja.setIcon(new ImageIcon(fil));
                                
                                
                                pagina.add(hoja);
                                add(pagina);
                                hoja.updateUI();
                                pagina.updateUI();
                                
                                subPagina = 0;
                                
                                return "a";
                            } else {
                                
                                String fil = "C:\\Cuentos\\"+cuento+"\\"+ NumCuentos[i]
                                        + "\\" + subPagina + ".jpg";
                                
                                System.out.println(fil);
                                hoja.setIcon(new ImageIcon(fil));
                                
                                hoja.updateUI();
                                pagina.updateUI();
                                subPagina++;
                                setVisibleMenu();
                                
                                return "a";

                            }

                        }
                        if (tipoO == 'F') {
                            if (subPagina == subCuentos.length-1) {
                                setVisibleFin();
                                String fil = "C:\\Cuentos\\"+cuento+"\\"+ NumCuentos[i]
                                        + "\\" + subPagina + ".jpg";
                                
                                
                                System.out.println(fil);
                                hoja.setIcon(new ImageIcon(fil));
                                
                                hoja.updateUI();
                                pagina.updateUI();
                                
                                    
                                return "a";

                            } else {
                                
                                String fil = "C:\\Cuentos\\"+cuento+"\\"+ NumCuentos[i]
                                        + "\\" + subPagina + ".jpg";
                                
                                System.out.println(fil);
                                hoja.setIcon(new ImageIcon(fil));
                                
                                hoja.updateUI();
                                pagina.updateUI();
                                subPagina++;
                                setVisibleMenu();
                                return "a";
                            }

                        }

                    }
                }

            }

            // }
        }
        return null;
    }
    private class SwingAction extends AbstractAction {
        public SwingAction() {
            putValue(NAME, "SwingAction");
            putValue(SHORT_DESCRIPTION, "Some short description");
        }
        public void actionPerformed(ActionEvent e) {
        }
    }
}