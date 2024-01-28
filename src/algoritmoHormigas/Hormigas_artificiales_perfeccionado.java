package algoritmoHormigas;


public class Hormigas_artificiales_perfeccionado {
    
       public static void main(String args[])

   {

 

      Hormigas_artificiales_perfeccionado hormiga_perfecta = new Hormigas_artificiales_perfeccionado();

      hormiga_perfecta.activar_hormiga();

   }//main  

 

   public void activar_hormiga()

   {

      Hormigas h= new Hormigas();

      h.explorar();

   }//activar_hormiga

 

 

 //Algoritmo de hormigas artificiales investigado y actualizado al miercoles 2 de agosto del 2017.

//Autor Rafael Angel Montero Fernpandez.

 

public class Hormigas

{

   private String vNombre_de_la_ormiga="";//No se crea un set ya que el nombre de la hormiga unicamente se pedirá al inicializar el objeto.

 

   private int vCantidad_de_caminos;

   private boolean mCamino_elegido_por_la_hormiga[];//

   private double mFeromonas_entre_visibilidad[], mPonderado_en_la_escala_de_probabilidades[];

   private double mPxy_probabilidad_de_un_camino_entre_la_sumatoria_de_todos[];

   public final double cnt_Q=0.0001;//No se a que apunta pero esta dentro de la formula.

   private Hormigas_ambiente vAmbiente_global=null;

 

 

   public Hormigas()

   {

      this.vCantidad_de_caminos=3;

      this.vAmbiente_global=new Hormigas_ambiente();

      this.vNombre_de_la_ormiga="Exploradora default";

      this.mFeromonas_entre_visibilidad=new double [vAmbiente_global.getLogitudes().length];//Estableciendo el tamaño de la matriz.

      this.mPonderado_en_la_escala_de_probabilidades=new double [vAmbiente_global.getLogitudes().length];

      this.mPxy_probabilidad_de_un_camino_entre_la_sumatoria_de_todos=new double [vAmbiente_global.getLogitudes().length];

      this.mCamino_elegido_por_la_hormiga=new boolean [vAmbiente_global.getLogitudes().length];

   }//Fin del cosntructor.

 

   public Hormigas(String nombre_de_la_hormiga, Hormigas_ambiente ambiente_de_la_hormiga)

   {

      this.vNombre_de_la_ormiga=nombre_de_la_hormiga;

      this.vAmbiente_global=ambiente_de_la_hormiga;//new Hormigas_ambiente();

      this.vNombre_de_la_ormiga="Exploradora default";

      this.mFeromonas_entre_visibilidad=new double [vAmbiente_global.getLogitudes().length];//Estableciendo el tamaño de la matriz.

      this.mPonderado_en_la_escala_de_probabilidades=new double [vAmbiente_global.getLogitudes().length];

      this.mPxy_probabilidad_de_un_camino_entre_la_sumatoria_de_todos=new double [vAmbiente_global.getLogitudes().length];

      this.mCamino_elegido_por_la_hormiga=new boolean [vAmbiente_global.getLogitudes().length];

      this.vCantidad_de_caminos=3;

   }//Fin del cosntructor.   

 

 

 

   public double []fProbabilidad_de_elegir_un_camino(Hormigas_ambiente ambiente_a_elegir)//Objeto inicializado con la cantidad de caminos a elegir.

   {

      int i=0;

      Hormigas_ambiente ambiente= new Hormigas_ambiente();

 

      double vSumatoria_de_probabilidades=0.0, vPonderado_en_la_escala_de_probabilidad=0.0;

      //System.out.println(ambiente.getFeromonas_en_el_camino().length);

      for(i=0;i <= ambiente.getFeromonas_en_el_camino().length-1;i++)

      {

 

         // Para calcular la probabilidad de elegir un camino primero se multiplica las feromonas en el camino por la visibilidad.

         this.mFeromonas_entre_visibilidad [i]= ambiente.getFeromonas_en_el_camino()[i] * ambiente.getVisibilidad()[i];

 

         //Luego se realiza una sumatoria de los caminos a elegir.

         vSumatoria_de_probabilidades += this.mFeromonas_entre_visibilidad [i];

      }//for

 

 

      double vTemp=0.0;

 

      for(i=0;i<ambiente.getFeromonas_en_el_camino().length;i++)

      {

         //Se calcula el Pxy.

         this.mPxy_probabilidad_de_un_camino_entre_la_sumatoria_de_todos[i] = this.mFeromonas_entre_visibilidad [i]/vSumatoria_de_probabilidades;

         //Se realiza un ponderado para establecer una escala de probabilidades.

         this.mPonderado_en_la_escala_de_probabilidades[i]=mPxy_probabilidad_de_un_camino_entre_la_sumatoria_de_todos [i] + vTemp;

         vTemp = this.mPonderado_en_la_escala_de_probabilidades[i];//Como es una suma no hay nada que hacerle, el primer valor es el de la primera probabilidad.

      }//for

 

      return mPonderado_en_la_escala_de_probabilidades;//El mPonderado_en_la_escala_de_probabilidades es el resultado final de la probabilidad de elegir un camino.

   }//Fin de fProbabilidad_de_elegir_un_camino

 

   public double []getPxy()//Es la probabilidad de elegir el camino entre el punto inicial x y el punto final y. Esto no es el ponderado y por lo tanto no es la posibilidad final para elegir ese camino.

   {

      return this.mPxy_probabilidad_de_un_camino_entre_la_sumatoria_de_todos;

   }//getPxy

 

   public double []fRecorrido_de_regreso(Hormigas_ambiente recorrido_de_la_hormiga)//Cantidad de feromonas que la hormiga k o k esima deposita en su recorido.

   {//Esta fincion acctualiza a setFeromonas_en_el_camino() del class ambiente.

      //Q/LK 

      //LK= Longitud o distancia del camino recorrido por la hormiga k o k esima en su regresp a la colonia.

      double mRecorrido_de_regreso[]=new double[recorrido_de_la_hormiga.getLogitudes().length] ;

      //Cuando no se conoce la distancia.

      //Tambien = (Math.squrt(Math.pow(finX-inicioX) + math.pow(finB-inicioB,2);Solo en caso que cada nodo tueviera un valor y sumados dos puntos o nmodos diferentes darian la lingitud pero en este caso la longitud ya fue dada.

      for (int i=0;i< recorrido_de_la_hormiga.getLogitudes().length;i++)

      {

         mRecorrido_de_regreso [i]= this.cnt_Q/recorrido_de_la_hormiga.getLogitudes()[i];//Asi cada fraccion del camino tendrá un poco de feromonas.

      }//for

 

      return mRecorrido_de_regreso;//Esto solo aplica si la hormiga recorrio ese camino. Y se supone que el camino no recorrido es cero.

   }// fRecorrido_de_regreso Cantidad_de_feromonas_a_depositar

 

   @Override

   public String toString()

   {

      String vDatos_de_la_hormiga="";

 

      for (int i=0;i<getPxy().length;i++)

      {

         vDatos_de_la_hormiga+="Nombre del camino " + this.vAmbiente_global.getCaminos()[i] + "\n";

         vDatos_de_la_hormiga+="Nombre de la hormiga: Exploradora\n";

         vDatos_de_la_hormiga+="Probabilidad de elegir el camino entre el punto inicial x & el punto final y: " +  getPxy()[i] + "\n";

         vDatos_de_la_hormiga+= "Feromonas multiplicado por la visibilidad: " + this.mFeromonas_entre_visibilidad[i] + "\n";

         vDatos_de_la_hormiga+= "Camino elegido por la hormiga " + this.mCamino_elegido_por_la_hormiga[i] + "\n\n";

      }//for

 

      return vDatos_de_la_hormiga;//

   }//toString

   //__________________________________________________________________________________

   //Buscando un camino entre dos posibles caminos.

 

 

   //----------------------------------------------------------------------------------

   private int elegir_2_caminos(double mBusqueda[], int id,boolean escribir_datos_en_pantalla)

   {

 

      if (id==-1){id=0;}

      String vDetalles="";

      int vRespuesta=0;

 

            if (mBusqueda[id] > mBusqueda[id-1])

            {

               vDetalles=("Id del camino elegido:" + id + "\nCamino: " + this.vAmbiente_global.getCaminos()[id] + "\n\n");

               vRespuesta=id;

               //continue;

            }//if

            else if( mBusqueda[id-1] > mBusqueda[id])//( elegir_2_caminos(mBusqueda/*Comapara el primero y el segundo de 4.*/,id,false) > elegir_2_caminos(mBusqueda,id,false)/*Compara el tercero y el cuarto de 4*/)

            {

              vDetalles=("Id del camino elegido:" + id + "\nCamino: " + this.vAmbiente_global.getCaminos()[id] + "\n\n");

              vRespuesta=id;

              //continue;

            }//else if   

 

               if(escribir_datos_en_pantalla=true)//Se pone en true solo cuando se van a elegir dos caminos y en false cuando se van a elegir 4 caminos que lo que se necesita, es que devuelva la posicion del camino.

               {

                  this.mCamino_elegido_por_la_hormiga[vRespuesta]=true;

                  this.vAmbiente_global.setVeces_que_ha_sido_elegido(vRespuesta);

                  System.out.println(vDetalles);

               }//Fin del if

 

               return vRespuesta;

 

   }//elegir_2_caminos

 

   //-----------------------------------------------------------------------------------

   //Buscando elegir un camino entre 4 posibles caminos.

   private int elegir_4_caminos(double mBusqueda[], int id)

   {

      if (id==-1){id=0;}

 

      String vDetalles="";

      int vRespuesta=0;

 

            if(elegir_2_caminos(mBusqueda/*Comapara el primero y el segundo de 4.*/,id,false)  > elegir_2_caminos(mBusqueda,id,false)/*Compara el tercero y el cuarto de 4*/)

            {

               vDetalles=("Id del camino elegido:" + id + "\nCamino: " + this.vAmbiente_global.getCaminos()[id] + "\n\n");

               vRespuesta=id;

               //continue;

            }//if

            else if( elegir_2_caminos(mBusqueda/*Comapara el primero y el segundo de 4.*/,id,false) > elegir_2_caminos(mBusqueda,id,false)/*Compara el tercero y el cuarto de 4*/)

            {

              vDetalles=("Id del camino elegido:" + id + "\nCamino: " + this.vAmbiente_global.getCaminos()[id] + "\n\n");

              vRespuesta=id;

              //continue;

            }//else if   

 

            this.mCamino_elegido_por_la_hormiga[vRespuesta]=true;

            this.vAmbiente_global.setVeces_que_ha_sido_elegido(vRespuesta);

 

            return vRespuesta;

   }//elegir_4_caminos

 

   //______________________________________________________________________

   //int m[]=new int[2];

   //--------------------------------------------------------------------------

   //Buscando solo 3 nodos o 3 caminos.

   private int elegir_3_caminos(double mBusqueda[], int id)

   {

      if (id==-1){id=0;}

 

            //Busqueda para elegir una de tres rutas.

            if( (mBusqueda[id] > mBusqueda[id-1]) &

               (mBusqueda[id] > mBusqueda[id-2]) )

            {

               System.out.println("Id del camino elegido:" + id + "\nCamino: " + this.vAmbiente_global.getCaminos()[id] + "\n\n");

               this.mCamino_elegido_por_la_hormiga[id]=true;

               this.vAmbiente_global.setVeces_que_ha_sido_elegido(id);

               //continue;

            }//if

            else if( mBusqueda[id-1] > mBusqueda[id-2])

            {

              System.out.println("Id del camino elegido:" + id + "\nCamino: " + this.vAmbiente_global.getCaminos()[id] + "\n\n");

              this.mCamino_elegido_por_la_hormiga[id]=true;

              this.vAmbiente_global.setVeces_que_ha_sido_elegido(id);

              //continue;

            }//else if

            else if( mBusqueda[id-1] < mBusqueda[id-2])

            {

              System.out.println("Id del camino elegido:" + id + "\nCamino: " + this.vAmbiente_global.getCaminos()[id] + "\n\n");

              this.mCamino_elegido_por_la_hormiga[id]=true;

              this.vAmbiente_global.setVeces_que_ha_sido_elegido(id);

              //continue;

            }//else  if      

      return id;//Se necesita que retorne la identidad del camino para otras operaciones.

 

   }//elegir_3_caminos

   //-----------------------------------------------------------------------------------

   private void setCantidad_de_caminos(int id)

   {//Esta parte me costo varios dias de solo analicis y mucha logica casera e intuicion ademas, mucha expereincia de programacion.

    //En caso de eliminar el nodo 8 desaparecerán dos caminos: 7 a 8 y 4 a 8. Entonces desactivelos del case para elegir 3 caminos y activelos en el case para elegir dos caminos.

 

      switch(id)

      {

         case 0://Eligiendo 3 caminos.

         case 7://3 a 7

         case 3://2 a 7  

 

            this.vCantidad_de_caminos=3;

            break;

         case 5://Eligiendo 4 caminos.

         case 4:

            this.vCantidad_de_caminos=4;

            break;

         case 2://Eligiendo 2 caminos.

         //case 3://2 a 7   

         case 8:

         case 6:

         //case 7://3 a 7   

         case 9://Fin original.

         //Case 12 y case 11 pueden ser desactivados de esta lista si lo que se quiere es que el algoritmo paré al llegar al nodo 8 pero si lo que se quiere es que el algoritmo siga hasta que se de una condicion de parada por ejemplo elegir la meta o ir cambiando los valores de los caminos durante la ejecusion del algoritmo, mejor dejelo asi. 

         case 12://4 a 8 //Puede omitirse ya que es el fin modificado.

         case 11://7 a 8 //Puede omitirse ya que es el fin modificado.

         //***************************************************************   

         case 10://7 a 4 //Fin original. 

            this.vCantidad_de_caminos=2;

            break;

 

            //En caso de detenerse en el objetivo.

         //case 12://4 a 8 //Puede omitirse ya que es el fin modificado.

         //case 11://7 a 8 //Puede omitirse ya que es el fin modificado.

            //System.out.println("He llegado al objetivo, desea que busque mejores caminos para llegar aquí.");

            //break;

            //***********************************************************

            //fin, solo si no se han agregado nodos nuevos pero yo agregué dos más.

            //break;

      }//Fin del suitch

 

 

   }//setCantidad_de_caminos

   private int getCantidad_de_caminos()

   {

      return this.vCantidad_de_caminos;

   }//getCantidad_de_caminos

   //-----------------------------------------------------------------------------------

   public int fRuta_elegida(double mbuscar_por_fermonas_visibilidad_distancia_probabilidad[])//Se ha elegido el tipo de datos a devolver como int para poder devolver el indice donde se encuentra la ruta elegida y asi nos ahorramos codigo.

   {//Hacer un for, un cotador de uno a 3, cada 3 iteraciones calcular cual camino fue elegido, por medio de feromonas, detener el for despues de 3 iteraciones, guardar el contador

 

      //Para no poner el largo parametro en varias partes del codigo, pero si es necesario que el parametro le comunique al programador para que sirve.

      //double mBusqueda_elegida[]=mbuscar_por_fermonas_visibilidad_distancia_probabilidad;//Aqui el parametro mismo comunica que datos puede recivir.

      for (int i=0; i < mbuscar_por_fermonas_visibilidad_distancia_probabilidad.length; i++)

      {

        //m[0]++;

         //En las siguientes condiciones se usaron primero las feromonas para elegir el camino, pero despues de varios experimentos he concluido que se usará la visibilidad de las hormigas, ya que arrojan mejores resultados. O al menos los resultados arrojados son los deseados por mi.

         if (i>=3)

         {

 

            if (getCantidad_de_caminos()==2)//Cada 3 iteraciones del bucle se lanza una ruta.

            {

               setCantidad_de_caminos ( elegir_2_caminos(mbuscar_por_fermonas_visibilidad_distancia_probabilidad, i, true) );

            }// if (this.vCantidad_de_caminos==2)

            else if(getCantidad_de_caminos()==3)

            {

               setCantidad_de_caminos (  elegir_3_caminos(mbuscar_por_fermonas_visibilidad_distancia_probabilidad, i) );

            }//else if(this.vCantidad_de_caminos==3)

            else if(getCantidad_de_caminos()==4)

            {

               setCantidad_de_caminos (  elegir_4_caminos(mbuscar_por_fermonas_visibilidad_distancia_probabilidad, i) );

               //this.vCantidad_de_caminos=0; //Se reinicia el contador.

            }//else if(this.vCantidad_de_caminos==3)         

 

         }//if i>=3

 

         //this.vCantidad_de_caminos++;

 

      }//For

 

      //vTemp_feromonas=this.vAmbiente_global.getFeromonas_en_el_camino()[i];

      //System.out.println(m[0] + "\n\n_____________\n");

 

      return 0;

   }//getRuta_elegida

   //______________________________________________________________________

 

   public void explorar()

   {

 

     for (int i=0;i<4;i++)

     {

        this.vAmbiente_global.setProbabilidades_de_ser_elegido(fProbabilidad_de_elegir_un_camino( this.vAmbiente_global));

 

        this.vAmbiente_global.actualizar_feromonas_en_el_camino ( fRecorrido_de_regreso( this.vAmbiente_global));

     }//for

 

 

     fRuta_elegida(this.vAmbiente_global.getVisibilidad());

      System.out.println(vAmbiente_global.toString() + "\n\nDatos de las hormigas:\n\n" + toString()   ) ;

 

   }//explorar

 

}//Fin del class

 

//Conclusiones, este es solo el algoritmo, no es el programa en si.

//No es un programa basado en el algoritmo sino que es en si el algoritmo puro.

//A partir de este algoritmo se puede diseñar un programa inteligente.

//En mis investigaciones con este algoritmo he llegado a la conclusion que para elegir determinado camino, debo basarme en la cantidad de feromonas depositadas. 

//Fue necesario crear 3 funciones diferentes para la busqueda del camino deseado.  

 

 ///////////////////////////////////////////////////////////////////////////////////////// 

 //Clase para programar el camino.

public class Hormigas_ambiente

{

   private String mCaminos[];//11 caminos diferentes; cada camino corresponde a la coneccion entre un nodo y otro.

   private int mNodos[];//5 aristas o nodos.

   private double mLogitudes[];//Corresponde a la medida de cada caminos o longitud.

   private double mVisibilidad[];//Visibilidad de la hormiga o mejor dicho visibilidad del camino. A mayor distancia menos visibilidad.

   private double mFeromonas_en_el_camino[];//Es la cantidad de feromonas depositadas en ese caminos, inicialmente 0.1, luego desaparese o va actualizandose dependiendo si es transcitado o no.

   private double mProbabilidades_de_ser_elegido[];

   private int mVeces_que_ha_sido_elegido[];//Veces que el id de este camino ha sido elegido.

   //Es lo mismo que la nomenclatura ev de evaporacion.

   public final double cnt_P_coeficiente_de_evaporacion_de_las_feromonas=0.1;//Para usar un timer o en cada intervalo ir evaporandolo a esta velocidad.

   public final double cnt_Alfa=1.68309;

   public final double cnt_Beta=1.28264;

 

//public enum enNodos{NODO_1(1),NODO_2(2),NODO_3(3),NODO_4(4),NODO_5(5); public int valor; private enNodos(int nuevo_valor){this.valor=nuevo_valor;} };//En dado caso para un experimento asi podria usarse. pero no se podria recorrer con un for.

   //Hay dos formas de utilizarlos.

   //Asi.

    //enNodos nodo4 = enNodos.NODO_4;

   //System.out.println("Nombre del nodo " + nodo4 + "\nvalor " + nodo4.valor); 

   //O asi:

   //System.out.println("Nombre del nodo " + enNodos.NODO_1 + "\nvalor " + enNodos.NODO_1.valor);

 

 

 

   public Hormigas_ambiente()

   {

      mCaminos = new String[13];

      //Valores de los caminos.8

      this.mCaminos[0]="1 a 2";

      this.mCaminos[1]="1 a 3";

      this.mCaminos[2]="1 a 6";

 

      this.mCaminos[3]="2 a 7";

      this.mCaminos[4]="2 a 3";

 

      this.mCaminos[5]="6 a 3";

      this.mCaminos[6]="6 a 5";

 

      this.mCaminos[7]="3 a 7";

      this.mCaminos[8]="3 a 5";

 

      this.mCaminos[9]="5 a 4";

 

      this.mCaminos[10]="7 a 4";

      this.mCaminos[11]="7 a 8";

      this.mCaminos[12]="4 a 8";

 

      this.mNodos = new int[6];

      //Valores de los nodos. Tambien se podria usar algo como una enumeracion.

      this.mNodos[0]=1;

      this.mNodos[1]=2;

      this.mNodos[2]=3;

      this.mNodos[3]=4;

      this.mNodos[4]=5;

      this.mNodos[5]=6;

 

      this.mLogitudes=new double[this.mCaminos.length];

      //Valores de todas las longitudes.

      this.mLogitudes[0]=5;

      this.mLogitudes[1]=3.1;

      this.mLogitudes[2]=5.2;

      this.mLogitudes[3]=5.2;

      this.mLogitudes[4]=4.9;

      this.mLogitudes[5]=3.2;

      this.mLogitudes[6]=4.7;

      this.mLogitudes[7]=3.0;

      this.mLogitudes[8]=6;

      this.mLogitudes[9]=5.5;

      this.mLogitudes[10]=4.8;

      this.mLogitudes[11]=7.1;

      this.mLogitudes[12]=6.98;

 

      this.mVisibilidad=new double[this.mLogitudes.length];

      //Valores de todas las visibilidades.

      for (int i=0;i < this.mLogitudes.length;i++)

      {

         this.mVisibilidad[i]=1 / this.mLogitudes[i];

      }//for

 

      this.mFeromonas_en_el_camino=new double[this.mLogitudes.length];

      //Estableciendo valores iniciales de las feromonas. No obstante, este valor decrese o se incrementa durante la interaccion de las hormigas.

      for (int i=0; i < this.mLogitudes.length;i++)

      {

         this.mFeromonas_en_el_camino[i]=0.1;//Valor inicial de feromonas en el camino.

      }//for

 

      this.mProbabilidades_de_ser_elegido=new double[this.mLogitudes.length];

      this.mVeces_que_ha_sido_elegido=new int[this.mLogitudes.length];

   }//Fin del cosntructor.   

 

 

   public Hormigas_ambiente(int nueva_cantidad_de_caminos,int nueva_cantidad_de_nodos)

   {

      this.mCaminos = new String[nueva_cantidad_de_caminos];//Tamaño del camino.

      this.mNodos =new int[nueva_cantidad_de_nodos];//Cantidad de nodos o conecciones entre cada camino.

      //Valores iniciales

 

      for (int i:mNodos)

      {

         this.mNodos[i]=i;//Solo espero que los numeros se carguen en orden.

      }//for.

 

      this.mLogitudes=new double[nueva_cantidad_de_caminos];//Se usa el mismo arametro porque se le esta dando el tamaño al camino.

 

      mVisibilidad=new double[nueva_cantidad_de_caminos];//Se usa el mismo arametro porque se le esta dando el tamaño al camino.

 

      this.mFeromonas_en_el_camino=new double[nueva_cantidad_de_caminos];//Se usa el mismo arametro porque se le esta dando el tamaño al camino.

      //Estableciendo valores iniciales de las feromonas. No obstante, este valor decrese o se incrementa durante la interaccion de las hormigas.

      for (int i=0; i<=10;i++)

      {

         this.mFeromonas_en_el_camino[i]=0.1;//Valor inicial de feromonas en el camino.

      }//for

 

      this.mProbabilidades_de_ser_elegido=new double[nueva_cantidad_de_caminos];//Se usa el mismo arametro porque se le esta dando el tamaño al camino.

      this.mVeces_que_ha_sido_elegido=new int[this.mLogitudes.length];

   }//Fin del cosntructor.   

 

   //________________________________________________________

 

   //Las siguientes propiedades se usan de la siguiente manera:

   //System.out.println(getCaminos()[0]);

   public void setCaminos(String nuevos_caminos[])

   {

      this.mCaminos=nuevos_caminos;

   }//setCaminos

 

   public String []getCaminos()

   {

      return this.mCaminos;

   }//getCaminos

   //________________________________________________________

 

 

   public void setNodos(int nuevos_nodos[])

   {

      this.mNodos=nuevos_nodos;

   }//setNodos

 

   public int []getNodos()

   {

      return this.mNodos;

   }//getNodos

 

   //_______________________________________________________

 

   public void setProbabilidades_de_ser_elegido(double mNuevnuevas_Probabilidades_de_ser_elegido[])

   {

      this.mProbabilidades_de_ser_elegido = mNuevnuevas_Probabilidades_de_ser_elegido;

   }//setProbabilidades_de_ser_elegido

 

   public double []getProbabilidades_de_ser_elegido()

   {

      return this.mProbabilidades_de_ser_elegido;

   }//getProbabilidades_de_ser_elegido      

   //________________________________________________________

 

   public void setLogitudes(double nuevas_longitudes[])

   {

      this.mLogitudes = nuevas_longitudes;

   }//setLogitudes

 

   public double []getLogitudes()

   {

      return this.mLogitudes;

   }//getLogitudes

   //________________________________________________________   

 

  /* public void setVisibilidad(double nuevas_visibilidades[])

   {

      mVisibilidad=nuevas_visibilidades;

   }//Visibilidad

   No es necesaria...

   */

 

   public double []getVisibilidad()//Para cargarse en otra matriz u obtener un indice.

   {

      for (int i=0;i<=10;i++)//Se vuelven a calcular los valores por si acaso las distancias han cambiado.

      {

         this.mVisibilidad[i]=1 / this.mLogitudes[i];

      }//for

 

      return this.mVisibilidad;

   }//Visibilidad

   //________________________________________________________  

 

 

   public void setFeromonas_en_el_camino(double []nuevas_feromonas_en_el_camino)

   {

      this.mFeromonas_en_el_camino = nuevas_feromonas_en_el_camino;

   }//setFeromonas_en_el_camino

 

   public double []getFeromonas_en_el_camino()

   {

      return this.mFeromonas_en_el_camino;

   }//getFeromonas_en_el_camino

   //________________________________________________________ 

 

 

   public double evaporacion_de_las_feromonas()//Metodo opcional.

   {

      return this.cnt_P_coeficiente_de_evaporacion_de_las_feromonas;

        //(1-cnt_P_coeficiente_de_evaporacion_de_las_feromonas) * getFeromonas_en_el_camino() + //getCantidad_de_feromonas_a_depositar

   }//evaporacion_de_las_feromonas

 

   public void actualizar_feromonas_en_el_camino(double recorrido_de_la_hormiga[])

   {

                //Puede ser cnt_P_coeficiente_de_evaporacion_de_las_feromonas pero mejor pondré 1.

 

      for (int i=0; i < getFeromonas_en_el_camino().length;i++)

       {

           this.mFeromonas_en_el_camino[i]= (1- this.cnt_P_coeficiente_de_evaporacion_de_las_feromonas) * getFeromonas_en_el_camino()[i] + recorrido_de_la_hormiga[i];

       }//for

 

   }//actualizar_feromonas_en_el_camino

 

   //_____Sirve para obtener la cantidad de veces que las hormigas han transcitado esa ruta.

   //Solo aparese elegido una vez por cada hormiga, pero entonces en otra instancia se realizará una sumatoria de todas las hormigas para darle valores.

   public void setVeces_que_ha_sido_elegido(int id)

   {

      this.mVeces_que_ha_sido_elegido[id]++;

   }//setVeces_que_ha_sido_elegido

 

   public int []getVeces_que_ha_sido_elegido()

   {

      return this.mVeces_que_ha_sido_elegido;

   }//getVeces_que_ha_sido_elegido   

   //______________________________________________________________________________

 

   @Override

   public String toString()

   {

 

      String vDatos_del_camino="Datos del camino o ambiente\n\n";

      int vContador_de_nodos=0;

 

      for (int i=0;i < this.mCaminos.length;i++)

      {

         vDatos_del_camino +="Nombre del camino " + this.mCaminos[i] + "\n";

 

         if (vContador_de_nodos < this.mNodos.length)

         {

            vDatos_del_camino +="Nombre del nodo " + this.mNodos[vContador_de_nodos] +"\n";

            vContador_de_nodos++;

         }//if

 

         vDatos_del_camino +="Longitud del camino " + this.mLogitudes[i] +"\n";

         vDatos_del_camino +="Visibilidad del camino " + this.mVisibilidad[i] +"\n";

         vDatos_del_camino +="Cantidad de feromonas en el camino " + this.mFeromonas_en_el_camino[i] +"\n";

         vDatos_del_camino +="Probabilidades de ser elegido " + this.mProbabilidades_de_ser_elegido[i] +"\n";

         vDatos_del_camino +="Veces que este camino ha sido elegido " +  getVeces_que_ha_sido_elegido()[i] +"\n";

         vDatos_del_camino +="\n\n";

      }

 

      return vDatos_del_camino;

   }

 

}//Fin del class

}
