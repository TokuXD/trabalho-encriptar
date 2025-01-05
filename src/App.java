            import java.io.File;
            import java.io.FileWriter; 
            import java.util.Scanner;

            public class App {
                public static void main(String[] args) throws Exception {
                    
                    Scanner resposta = new Scanner (System.in);

                    while (true){
                    System.out.println("1 - Gravar ficheiro");
                    System.out.println("2 - Ler ficheiro");
                    System.out.println("3 - Encriptar Ficheiro");
                    System.out.println("4 - Desencriptar Ficheiro");
                    System.out.println("5 - Terminar");
                    
                    System.out.println("\n escolha (0,5):");

                    
                        int Respostan = resposta.nextInt();
                        
                        switch (Respostan) {
                            case 1: 
                            GravarFicheiro();
                            break;

                            case 2:
                            LerFicheiro();
                            break;

                            case 3:
                            EncriptarFicheiro();
                            break;

                            case 4:
                            Desencriptar();
                            break;

                            case 5:
                            System.out.println("Programa terminado. Adeus!");
                            resposta.close(); 
                            return;
                            
                            default:
                            System.out.println("Opção inválida! Tente novamente.");
                            
                        }
                        
                       
                    }
                }


        
                public static void GravarFicheiro(){
                Scanner input = new Scanner(System.in);
                    System.out.println("introduza o nome do ficheiro: ");
                    String nomeFicheiro = (input.nextLine() + ".txt");
                    System.out.println("introduza o texto q quer gravar: ('ENTER para terminar')");
                    String textoCompleto = input.nextLine();
                    try {
                        
                        File OBJ = new File(nomeFicheiro);
                        if (OBJ.createNewFile()){
                            System.out.println(" ficheiro criado:  " + nomeFicheiro);
                        }else{
                            System.out.println("Ficheiro ja existe ");
                        }
                        FileWriter Escrever = new FileWriter(nomeFicheiro);
                        Escrever.write(textoCompleto.toLowerCase());
                        Escrever.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                input.close();
                };

            public static void LerFicheiro(){
                Scanner input = new Scanner(System.in);
                System.out.println("Escreva o nome do Ficheiro que quer ler:");
                String nomeFicheiro = (input.nextLine()+".txt");
                try{
                File OBJ = new File(nomeFicheiro);
                Scanner Leitor = new Scanner(OBJ);
                while(Leitor.hasNextLine()){
                String data = Leitor.nextLine();
                System.out.println(data);
                }
                Leitor.close();
                input.close();
                }catch(Exception e){
                    System.out.println("Erro");
                }
            }

            public static void EncriptarFicheiro(){

                Scanner input = new Scanner(System.in);
                System.out.println("Escreva o nome do ficheiro que deseja encriptar: ");
                String nomeFicheiro = (input.nextLine() + ".txt");
                System.out.println("Introduza a chave para encriptar (1-25): ");
                int chaveEncriptaçao = input.nextInt();
                input.nextLine();
                System.out.println("Indique o nome do ficheiro para onde será gravado o texto encriptado: ");
                String Nome = input.nextLine();
                try {
                    File ficheiro = new File(nomeFicheiro);
                    Scanner leitor = new Scanner(ficheiro); 
                    String nomeFicheiroEncriptado = (Nome + ".txt");
                    FileWriter escreverenc = new FileWriter(nomeFicheiroEncriptado); 
                    while (leitor.hasNextLine()) {  
                        String linha = leitor.nextLine();
                        for (int i = 0; i < linha.length(); i++) {
                            char letra = linha.charAt(i);
                            if (letra >= 'a' && letra <= 'z') {
                                
                                letra = (char) (((letra - 'a' + chaveEncriptaçao) % 26) + 'a');      
                                ///chaveEncriptaçao = letra;
                            } 
                                
                                                   
                            escreverenc.write(letra);
                        } 
                        escreverenc.write("\n");
                    }
                    leitor.close();
                    escreverenc.close();
                    System.out.println("Texto encriptado gravado no ficheiro: " + nomeFicheiroEncriptado);
                } catch (Exception e) {
                    System.out.println("Erro ao encriptar o ficheiro: " + e.getMessage());
                }
                input.close();
            }


            public static void Desencriptar(){
          Scanner input = new Scanner(System.in);
          System.out.println("qual e o nome do ficheiro q pretende desencriptar: ");
          String nomeFicheirodes = (input.nextLine() + ".txt");
          System.out.println("qual foi a chave usada para encriptar o ficheiro: ");
          int chavedes = input.nextInt(); 
          input.nextLine();

             try{
               File ficheirodes = new File(nomeFicheirodes);
                Scanner leitordes =  new Scanner(ficheirodes);
                System.out.println("escreva o nome do ficheiro para onde ira ser escrito o texto desencriptado:");        
                String nomeFicheiroDes = (input.nextLine()+ ".txt");
                FileWriter escreverdes = new FileWriter(nomeFicheiroDes);
                while (leitordes.hasNextLine()){
                    String linhades = leitordes.nextLine();
                    for (int i = 0; i<linhades.length(); i++){
                        char letrades = linhades.charAt(i);
                        if (letrades >= 'a' && letrades <= 'z'){
                            letrades = (char) ('a' + (letrades - 'a' - chavedes + 26) % 26);     
                        }
                        escreverdes.write(letrades);
                    }
                    escreverdes.write("\n");
                }
             escreverdes.close();
             leitordes.close();
             input.close();
             System.out.println("Texto desencriptado gravado no ficheiro: " + nomeFicheiroDes);
             }catch(Exception e){
                System.out.println("ta alguma merda errada");
             }

            }
        }
