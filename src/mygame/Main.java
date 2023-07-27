package mygame;
import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import javax.swing.JOptionPane;




/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Main extends SimpleApplication implements ActionListener {
    // Variable para guardar la distancia mínima para enviar el mensaje
  // Variable para guardar la distancia mínima para enviar el mensaje
    private float distanciaMinima = 5.0f; // Ajusta este valor a la distancia deseada
    private boolean mensajeEnviado = false; // Variable para indicar si el mensaje ya se ha enviado
    private final float distanciaUmbral = 0.1f; // Umbral para determinar si el jugador se alejó lo suficiente para enviar el mensaje nuevamente
  private Spatial sceneModel;
  private BulletAppState bulletAppState;
  private RigidBodyControl landscape,landscape2,landscape3,landscape4,landscape5, landscape6,landscape7,landscape8,landscape9;
  private CharacterControl player;
  private Vector3f walkDirection = new Vector3f();
  private boolean left = false, right = false, up = false, down = false;
  private boolean topView = false; // Variable para indicar si estamos en vista cenital
  private boolean bandera=false;
  BitmapText text;

  public static void main(String[] args) {
        Main app = new Main();
    app.start();
  }
  private Spatial touchedObject;
  /**
     * Método para calcular la distancia entre dos puntos en el espacio 3D.
     */

Spatial casona, tumba,esqueleto,cartelT, platos, jarrones, jarron;
Spatial objeto2, objeto3, objeto4, objeto5, persona1, piedras, ac, arbol, mono, mono2,mono3, pelota, c1, c2, c3, c4, c5, c6, c7, ca1,ca2,ca3,ca4,ca5,ca6,ca7,lp,li; // Variable para almacenar el segundo objeto j3o
  @Override
  public void simpleInitApp() {
      
      //TEXTO
      BitmapFont myFont=assetManager.loadFont("Interface/Fonts/Cactus-Town.fnt");
      text=new BitmapText(myFont, false);
      text.setText("Templo H");
      text.setSize(6);
      text.setColor(ColorRGBA.Black);
      text.setLocalTranslation(60, 50, -40);
      text.rotate(0, 50, 0);
      rootNode.attachChild(text);
      //TEMPLO SUR
      text=new BitmapText(myFont, false);
      text.setText("Templo Sur");
      text.setSize(6);
      text.setColor(ColorRGBA.Black);
      text.setLocalTranslation(70, 45, 300);
      text.rotate(0, FastMath.DEG_TO_RAD * 180, 0);
      rootNode.attachChild(text);
      //PALACIO
      text=new BitmapText(myFont, false);
      text.setText("Palacio");
      text.setSize(6);
      text.setColor(ColorRGBA.Black);
      text.setLocalTranslation(280, 45, 100);
      text.rotate(0, FastMath.DEG_TO_RAD * 270, 0);
      rootNode.attachChild(text);
      //LOS DANZANTES
      text=new BitmapText(myFont, false);
      text.setText("Edificio M");
      text.setSize(6);
      text.setColor(ColorRGBA.Black);
      text.setLocalTranslation(-180, 45, 180);
      text.rotate(0, FastMath.DEG_TO_RAD * 90, 0);
      rootNode.attachChild(text);
      //EDIFICIO IV
      text=new BitmapText(myFont, false);
      text.setText("Edificio IV");
      text.setSize(6);
      text.setColor(ColorRGBA.Black);
      text.setLocalTranslation(-180, 45, -60);
      text.rotate(0, FastMath.DEG_TO_RAD * 90, 0);
      rootNode.attachChild(text);
      
      
      
      DirectionalLight sun = new DirectionalLight();
        sun.setColor(ColorRGBA.White.mult(0.0f));
        sun.setEnabled(true);
        rootNode.addLight(sun);
        flyCam.setMoveSpeed(20);
        // Inicializar la cámara en una posición y rotación inicial
      //  cam.setLocation(new Vector3f(0, 10, 0));// Ajusta la altura de la vista cenital
       // cam.lookAt(Vector3f.ZERO, Vector3f.UNIT_Z); // Mirar hacia abajo (hacia el eje negativo Z)
        
       DirectionalLight sun2 = new DirectionalLight();
        sun2.setDirection(new Vector3f(40, 40, 40).normalizeLocal()); // Dirección de la luz
        sun2.setColor(ColorRGBA.White); // Color de la luz
        rootNode.addLight(sun2);
        
        DirectionalLight sun3 = new DirectionalLight();
        sun3.setDirection(new Vector3f(-1000, 40, -200).normalizeLocal()); // Dirección de la luz
        sun3.setColor(ColorRGBA.White); // Color de la luz
        rootNode.addLight(sun3);
        
        DirectionalLight sun4 = new DirectionalLight();
        sun4.setDirection(new Vector3f(70, 50, 200).normalizeLocal()); // Dirección de la luz
        sun4.setColor(ColorRGBA.White); // Color de la luz
        rootNode.addLight(sun4);
        

        //CARTEL PRINCIPAL
        lp=assetManager.loadModel("Models/letreroprincipal/letreroprincipal.j3o");
        lp.setLocalTranslation(70, 0, -140);
        lp.rotate(0, FastMath.DEG_TO_RAD * 180, 0);
        lp.scale (0.15f);
        rootNode.attachChild(lp);
        //CARTEL INDICACIONES
        li=assetManager.loadModel("Models/letreroindicaciones/letreroindicaciones.j3o");
        li.setLocalTranslation(40, 0, -135);
        li.rotate(0, FastMath.DEG_TO_RAD * 180, 0);
        li.scale (0.1f);
        rootNode.attachChild(li);
//CARTEL TEMPLO H
        c1=assetManager.loadModel("Models/templo h/templo h.j3o");
        c1.setLocalTranslation(25, 0, 65);
        c1.rotate(0, FastMath.DEG_TO_RAD * 270, 0);
        c1.scale (0.15f);
        rootNode.attachChild(c1);
        //CARTEL TEMPLO SUR
        c2=assetManager.loadModel("Models/templosur/templosur.j3o");
        c2.setLocalTranslation(120, 0, 200);
        c2.rotate(0, FastMath.DEG_TO_RAD * 180, 0);
        c2.scale (0.15f);
        rootNode.attachChild(c2);
        //CARTEL PALACIO
        c3=assetManager.loadModel("Models/palacio2/palacio.j3o");
        c3.setLocalTranslation(160, 0, 115);
        c3.rotate(0, FastMath.DEG_TO_RAD * 270, 0);
        c3.scale (0.15f);
        rootNode.attachChild(c3);
        //CARTEL JUEGO DE PELOTA
        c4=assetManager.loadModel("Models/juegodepelota2/juegodepelota2.j3o");
        c4.setLocalTranslation(180, 0, -110);
        c4.rotate(0, FastMath.DEG_TO_RAD * 270, 0);
        c4.scale (0.15f);
        rootNode.attachChild(c4);
        //CARTEL EDIFICIO M
        c5=assetManager.loadModel("Models/edificiom/edificiom.j3o");
        c5.setLocalTranslation(-20, 0, 165);
      c5.rotate(0, FastMath.DEG_TO_RAD * 90, 0);
        c5.scale (0.15f);
        rootNode.attachChild(c5);
        //CARTEL EDIFICIO IV
        c6=assetManager.loadModel("Models/edificio4/edificio4.j3o");
        c6.setLocalTranslation(-20, 0, -35);
      c6.rotate(0, FastMath.DEG_TO_RAD * 90, 0);
        c6.scale (0.15f);
        rootNode.attachChild(c6);
        //CARTEL DANZANTES
        c7=assetManager.loadModel("Models/danzantes/danzantes.j3o");
        c7.setLocalTranslation(-70, 0, 100);
      c7.rotate(0, FastMath.DEG_TO_RAD * 90, 0);
        c7.scale (0.15f);
        rootNode.attachChild(c7);
        //CARTELES
        ca1=assetManager.loadModel("Models/le1/le1.j3o");
        ca1.setLocalTranslation(50, 0, 120);
        ca1.rotate(0, FastMath.DEG_TO_RAD * 90, 0);
        ca1.scale (0.15f);
        rootNode.attachChild(ca1);
        ca2=assetManager.loadModel("Models/le2/le2.j3o");
        ca2.setLocalTranslation(45, 0, 70);
        ca2.rotate(0, FastMath.DEG_TO_RAD * 90, 0);
        ca2.scale (0.15f);
        rootNode.attachChild(ca2);
        ca3=assetManager.loadModel("Models/le3/le3.j3o");
        ca3.setLocalTranslation(95, 0, 50);
        ca3.rotate(0, FastMath.DEG_TO_RAD * 270, 0);
        ca3.scale (0.15f);
        rootNode.attachChild(ca3);
        ca4=assetManager.loadModel("Models/le4/le4.j3o");
        ca4.setLocalTranslation(88, 0, -90);
        ca4.rotate(0, FastMath.DEG_TO_RAD * 270, 0);
        ca4.scale (0.15f);
        rootNode.attachChild(ca4);
        ca5=assetManager.loadModel("Models/le5/le5.j3o");
        ca5.setLocalTranslation(75, 23, -5);
        ca5.rotate(0, FastMath.DEG_TO_RAD *90, 0);
        ca5.scale (0.15f);
        rootNode.attachChild(ca5);
        ca6=assetManager.loadModel("Models/le6/le6.j3o");
        ca6.setLocalTranslation(65, 0, 115);
        ca6.rotate(0, FastMath.DEG_TO_RAD * 180, 0);
        ca6.scale (0.15f);
        rootNode.attachChild(ca6);
        ca7=assetManager.loadModel("Models/le7/le7.j3o");
        ca7.setLocalTranslation(40, 0, -105);
        ca7.rotate(0, 0, 0);
        ca7.scale (0.15f);
        rootNode.attachChild(ca7);
        //ARBOL
        arbol=assetManager.loadModel("Models/Tree/Tree.j3o");
        arbol.setLocalTranslation(-60, 0, 50);
        arbol.scale (9.0f);
        rootNode.attachChild(arbol);
        arbol=assetManager.loadModel("Models/Tree/Tree.j3o");
        arbol.setLocalTranslation(-80, 0, 40);
        arbol.scale (8.0f);
        rootNode.attachChild(arbol);
        arbol=assetManager.loadModel("Models/Tree/Tree.j3o");
        arbol.setLocalTranslation(-40, 0, 250);
        arbol.scale (9.0f);
        rootNode.attachChild(arbol);
        arbol=assetManager.loadModel("Models/Tree/Tree.j3o");
        arbol.setLocalTranslation(190, 0, 250);
        arbol.scale (9.0f);
        rootNode.attachChild(arbol);
        arbol=assetManager.loadModel("Models/Tree/Tree.j3o");
        arbol.setLocalTranslation(190, 0, -120);
        arbol.scale (9.0f);
        rootNode.attachChild(arbol);
        arbol=assetManager.loadModel("Models/Tree/Tree.j3o");
        arbol.setLocalTranslation(200, 0, -135);
        arbol.scale (9.0f);
        rootNode.attachChild(arbol);
        arbol=assetManager.loadModel("Models/Tree/Tree.j3o");
        arbol.setLocalTranslation(200, 0, -10);
        arbol.scale (9.0f);
        rootNode.attachChild(arbol);
        arbol=assetManager.loadModel("Models/Tree/Tree.j3o");
        arbol.setLocalTranslation(230, 0, 10);
        arbol.scale (9.0f);
        rootNode.attachChild(arbol);
        //ACCESORIOS
        ac=assetManager.loadModel("Models/acc/acc.j3o");
        ac.setLocalTranslation(88, -3, -5);
        ac.rotate(0, FastMath.DEG_TO_RAD * 270, 0);
        ac.scale (0.05f);
        rootNode.attachChild(ac);
        //PIEDRAS
        piedras=assetManager.loadModel("Models/piedras/piedras.j3o");
        piedras.setLocalTranslation(-40, 0, 100);
        piedras.rotate(0, FastMath.DEG_TO_RAD * 180, 0);
        piedras.scale(0.1f);
        rootNode.attachChild(piedras);
        //JUEGO DE PELOTA
        pelota=assetManager.loadModel("Models/juegodepelota/juegodepelota.j3o");
        pelota.setLocalTranslation(200, (float) 0.01, -110);
        pelota.scale(0.02f);
        pelota.rotate(0, FastMath.DEG_TO_RAD * 270, 0);
        rootNode.attachChild(pelota);
        //PERSONA
        persona1=assetManager.loadModel("Models/personaa2/personaa2.j3o");
        persona1.setLocalTranslation(10, 0, 10);
        persona1.scale(0.09f);
        rootNode.attachChild(persona1);
        casona = assetManager.loadModel("Models/piramide1/piramide1.j3o");
        casona.setLocalScale(2f);
        rootNode.attachChild(casona);
        // Carga el segundo objeto j3o y ajusta su escala y posición
        objeto2 = assetManager.loadModel("Models/piramide2/piramide2.j3o");
        objeto2.setLocalScale(2f);
       // objeto2.setLocalTranslation(new Vector3f(-3, 0, 0)); // Ajusta la posición según tu preferencia
        rootNode.attachChild(objeto2); // Agrega el segundo objeto al Node
         // Agrega el Node a la raíz de la escena
     //   this.getRootNode().attachChild(rootNode);
     // Carga el tercer objeto j3o y ajusta su escala y posición
        objeto3 = assetManager.loadModel("Models/piramide3/piramide3.j3o");
        objeto3.setLocalScale(2f);
       // objeto2.setLocalTranslation(new Vector3f(-3, 0, 0)); // Ajusta la posición según tu preferencia
        rootNode.attachChild(objeto3); // Agrega el segundo objeto al Node
        // Carga el cuarto objeto j3o y ajusta su escala y posición
        objeto4 = assetManager.loadModel("Models/Palacio/Palacio.j3o");
        objeto4.setLocalScale(2f);
       // objeto4.setLocalTranslation(new Vector3f(-3, 0, 0)); // Ajusta la posición según tu preferencia
        rootNode.attachChild(objeto4); // Agrega el segundo objeto al Node
     // Carga el quinto objeto j3o y ajusta su escala y posición
        objeto5 = assetManager.loadModel("Models/central/central.j3o");
        objeto5.setLocalScale(2f);
       // objeto5.setLocalTranslation(new Vector3f(-3, 0, 0)); // Ajusta la posición según tu preferencia
        rootNode.attachChild(objeto5); // Agrega el segundo objeto al Node
        
        //MONITOS CENTRAL
        mono=assetManager.loadModel("Models/Mono1/monitotaparrabo.j3o");
        mono.setLocalTranslation(5, 0, 10);
        mono.scale(.9f);
        mono.rotate(0, FastMath.DEG_TO_RAD * 45, 0);
        rootNode.attachChild(mono);
        
        
        //MONITOS
        mono=assetManager.loadModel("Models/Mono1/monitotaparrabo.j3o");
        mono.setLocalTranslation(-80, 4.5f, -50);
        mono.scale(.6f);
        mono.rotate(0, FastMath.DEG_TO_RAD * 200, 0);
        rootNode.attachChild(mono);
        mono2=assetManager.loadModel("Models/Mono2/MONOLANZA.j3o");
        mono2.setLocalTranslation(-175, 20f, -70);
        mono2.scale(.6f);
        mono2.rotate(0, FastMath.DEG_TO_RAD * 90, 0);
        rootNode.attachChild(mono2);
        
         //MONITOS PIRAMIDE 1
        mono=assetManager.loadModel("Models/Mono1/monitotaparrabo.j3o");
        mono.setLocalTranslation(-90, 3.7f, 150);
        mono.scale(.6f);
        mono.rotate(0, FastMath.DEG_TO_RAD * 200, 0);
        rootNode.attachChild(mono);
        mono2=assetManager.loadModel("Models/Mono2/MONOLANZA.j3o");
        mono2.setLocalTranslation(-177, 18.8f, 137);
        mono2.scale(.6f);
        mono2.rotate(0, FastMath.DEG_TO_RAD * 90, 0);
        rootNode.attachChild(mono2);
        mono3=assetManager.loadModel("Models/Mono3/monopenacho.j3o");
        mono3.setLocalTranslation(-50, 14.6f, 137);
        mono3.scale(.6f);
        mono3.rotate(0, FastMath.DEG_TO_RAD * 270, 0);
        rootNode.attachChild(mono3);
        
        //TUMBA 5
        tumba=assetManager.loadModel("Models/Tumba5/Tumba5.j3o");
        tumba.setLocalTranslation(-90, 1, 250);
         tumba.scale(8f);
        tumba.rotate(0, FastMath.DEG_TO_RAD * 90, 0);
        rootNode.attachChild(tumba);
        //ESQUELETO
        esqueleto=assetManager.loadModel("Models/esqueleto/Esqueletohumano.j3o");
        esqueleto.setLocalTranslation(-120, 1.2f, 230);
         esqueleto.scale(60f);
       // tumba.rotate(0, FastMath.DEG_TO_RAD * 90, 0);
        rootNode.attachChild(esqueleto);
        //CARTEL TUMBA 5
        cartelT=assetManager.loadModel("Models/letrerotumba5/letrerotumba5.j3o");
        cartelT.setLocalTranslation(-81, 0, 231);
         cartelT.scale(0.15f);
       cartelT.rotate(0, FastMath.DEG_TO_RAD * 90, 0);
        rootNode.attachChild(cartelT);
        
        
        
          //MONITOS PIRAMIDE 3
        mono2=assetManager.loadModel("Models/Mono2/MONOLANZA.j3o");
        mono2.setLocalTranslation(40, 20.5f, 250);
        mono2.scale(.6f);
        mono2.rotate(0, FastMath.DEG_TO_RAD * 180, 0);
        rootNode.attachChild(mono2);
        mono2=assetManager.loadModel("Models/Mono2/MONOLANZA.j3o");
        mono2.setLocalTranslation(60, 20.5f, 260);
        mono2.scale(.6f);
        mono2.rotate(0, FastMath.DEG_TO_RAD * 180, 0);
        rootNode.attachChild(mono2);
        mono3=assetManager.loadModel("Models/Mono3/monopenacho.j3o");
        mono3.setLocalTranslation(90, 20.5f, 270);
        mono3.scale(.6f);
        mono3.rotate(0, FastMath.DEG_TO_RAD * 180, 0);
        rootNode.attachChild(mono3);
        
          //MONITOS PALACIO
        mono2=assetManager.loadModel("Models/Mono2/MONOLANZA.j3o");
        mono2.setLocalTranslation(220, 11.5f, 100);
        mono2.scale(.6f);
        mono2.rotate(0, FastMath.DEG_TO_RAD * 270, 0);
        rootNode.attachChild(mono2);
        mono3=assetManager.loadModel("Models/Mono3/monopenacho.j3o");
        mono3.setLocalTranslation(220, 11.5f, 80);
        mono3.scale(.6f);
        mono3.rotate(0, FastMath.DEG_TO_RAD * 270, 0);
        rootNode.attachChild(mono3);
        
          //MONITOS PIRAMIDE CENTRAL
        mono2=assetManager.loadModel("Models/Mono2/MONOLANZA.j3o");
        mono2.setLocalTranslation(80, 0, 40);
        mono2.scale(.6f);
        mono2.rotate(0, FastMath.DEG_TO_RAD * 180, 0);
        rootNode.attachChild(mono2);
        mono3=assetManager.loadModel("Models/Mono3/monopenacho.j3o");
        mono3.setLocalTranslation(50, 0, 40);
        mono3.scale(.6f);
        mono3.rotate(0, FastMath.DEG_TO_RAD * 180, 0);
        rootNode.attachChild(mono3);
        
        persona1=assetManager.loadModel("Models/personaa2/personaa2.j3o");
        persona1.setLocalTranslation(80, 0, -30);
        persona1.scale(.09f);
     //   persona1.rotate(0, FastMath.DEG_TO_RAD * 180, 0);
        rootNode.attachChild(persona1);
        mono3=assetManager.loadModel("Models/Mono1/monitotaparrabo.j3o");
        mono3.setLocalTranslation(50, 0, -30);
        mono3.scale(.6f);
       // mono3.rotate(0, FastMath.DEG_TO_RAD * 180, 0);
        rootNode.attachChild(mono3);

        
        persona1=assetManager.loadModel("Models/personaa2/personaa2.j3o");
        persona1.setLocalTranslation(120, 0, -70);
        persona1.scale(.09f);
     //   persona1.rotate(0, FastMath.DEG_TO_RAD * 180, 0);
        rootNode.attachChild(persona1);
        mono3=assetManager.loadModel("Models/Mono1/monitotaparrabo.j3o");
        mono3.setLocalTranslation(116, 0, -73);
        mono3.scale(.6f);
        mono3.rotate(0, FastMath.DEG_TO_RAD * 45, 0);
        rootNode.attachChild(mono3);
        mono=assetManager.loadModel("Models/Mono3/monopenacho.j3o");
        mono.setLocalTranslation(132, 0, -73);
        mono.scale(.6f);
        mono.rotate(0, FastMath.DEG_TO_RAD * -45, 0);
        rootNode.attachChild(mono);
      
        
        
        //PERSONAS ENTRE PALACIO Y EDIFICIO H
         persona1=assetManager.loadModel("Models/personaa2/personaa2.j3o");
        persona1.setLocalTranslation(130, 0, 160);
        persona1.scale(.09f);
        persona1.rotate(0, FastMath.DEG_TO_RAD * 180, 0);
        rootNode.attachChild(persona1);
        mono3=assetManager.loadModel("Models/Mono1/monitotaparrabo.j3o");
        mono3.setLocalTranslation(123, 0, 160);
        mono3.scale(.6f);
        mono3.rotate(0, FastMath.DEG_TO_RAD * 150, 0);
        rootNode.attachChild(mono3);
        mono=assetManager.loadModel("Models/Mono3/monopenacho.j3o");
        mono.setLocalTranslation(136, 0, 160);
        mono.scale(.6f);
        mono.rotate(0, FastMath.DEG_TO_RAD * -100, 0);
        rootNode.attachChild(mono);
        

    /** Set up Physics */
    bulletAppState = new BulletAppState();
    stateManager.attach(bulletAppState);
    //bulletAppState.getPhysicsSpace().enableDebug(assetManager);
    // We re-use the flyby camera for rotation, while positioning is handled by physics
    viewPort.setBackgroundColor(new ColorRGBA(0.7f, 0.8f, 1f, 1f));
    flyCam.setMoveSpeed(100);
    setUpKeys();
    setUpLight();
    // We set up collision detection for the scene by creating a
    // compound collision shape and a static RigidBodyControl with mass zero.
    CollisionShape sceneShape =
    CollisionShapeFactory.createMeshShape((Node) casona);
    landscape = new RigidBodyControl(sceneShape, 0);
    
    casona.addControl(landscape);
    
    //Para entrar dentro de la piramide
      sceneShape =
    CollisionShapeFactory.createMeshShape((Node) objeto2);
    landscape2 = new RigidBodyControl(sceneShape, 0);
    
    objeto2.addControl(landscape2);
    
     //Para entrar dentro de la piramide
      sceneShape =
    CollisionShapeFactory.createMeshShape((Node) objeto3);
    landscape3 = new RigidBodyControl(sceneShape, 0);
    
    objeto3.addControl(landscape3);
    
    
     //Para entrar dentro de la piramide
      sceneShape =
    CollisionShapeFactory.createMeshShape((Node) objeto4);
    landscape4 = new RigidBodyControl(sceneShape, 0);
    
    objeto4.addControl(landscape4);
    
    //Para entrar dentro de la piramide
      sceneShape =
    CollisionShapeFactory.createMeshShape((Node) objeto5);
    landscape5 = new RigidBodyControl(sceneShape, 0);
    
    objeto5.addControl(landscape5);
    
    sceneShape =
    CollisionShapeFactory.createMeshShape((Node) piedras);
    landscape6 = new RigidBodyControl(sceneShape, 0);
    
    piedras.addControl(landscape6);
    
    //Para entrar dentro de la piramide
      sceneShape =
    CollisionShapeFactory.createMeshShape((Node) tumba);
    landscape7 = new RigidBodyControl(sceneShape, 0);
    
    tumba.addControl(landscape7);
    //Para entrar PELOTA
      sceneShape =
    CollisionShapeFactory.createMeshShape((Node) pelota);
    landscape8 = new RigidBodyControl(sceneShape, 0);
    pelota.addControl(landscape8);
    //Para  esqueleto
      sceneShape =
    CollisionShapeFactory.createMeshShape((Node) esqueleto);
    landscape9 = new RigidBodyControl(sceneShape, 0);
    
    esqueleto.addControl(landscape9);
    // We set up collision detection for the player by creating
    // a capsule collision shape and a CharacterControl.
    // The CharacterControl offers extra settings for
    // size, stepheight, jumping, falling, and gravity.
    // We also put the player in its starting position.
    CapsuleCollisionShape capsuleShape = new CapsuleCollisionShape(0.4f, 2f, 1);
    player = new CharacterControl(capsuleShape, 0.4f);
    player.setJumpSpeed(10);
    player.setFallSpeed(10);
    player.setGravity(30);
    player.setPhysicsLocation(new Vector3f(-15, 20, -120));
    // We attach the scene and the player to the rootnode and the physics space,
    // to make them appear in the game world.
    rootNode.attachChild(casona);
    bulletAppState.getPhysicsSpace().add(landscape);
    bulletAppState.getPhysicsSpace().add(landscape2);
    bulletAppState.getPhysicsSpace().add(landscape3);
    bulletAppState.getPhysicsSpace().add(landscape4);
    bulletAppState.getPhysicsSpace().add(landscape6);
    bulletAppState.getPhysicsSpace().add(landscape7);
    bulletAppState.getPhysicsSpace().add(landscape8);
     bulletAppState.getPhysicsSpace().add(landscape9);
    if (bandera==true) {
        bulletAppState.getPhysicsSpace().add(landscape5);
    } else {
        bulletAppState.getPhysicsSpace().remove(landscape5);
    }
    
    bulletAppState.getPhysicsSpace().add(player);
  }
  private void setUpLight() {
    // We add light so we see the scene
    AmbientLight al = new AmbientLight();
    al.setColor(ColorRGBA.White.mult(1.3f));
    rootNode.addLight(al);
    DirectionalLight dl = new DirectionalLight();
    dl.setColor(ColorRGBA.White);
    dl.setDirection(new Vector3f(2.8f, -2.8f, -2.8f).normalizeLocal());
    rootNode.addLight(dl);
  }
   private void toggleTopView() {
    if (topView) {
        // Si estamos en vista cenital, cambiamos a la vista normal (vista desde el jugador)
        cam.setLocation(player.getPhysicsLocation().add(new Vector3f(0, 10, 0))); // Ajusta la altura para que esté sobre el jugador
        cam.lookAtDirection(player.getViewDirection(), Vector3f.UNIT_Z); // Mirar en la dirección en la que está mirando el jugador
    } else {
        // Si estamos en vista normal, cambiamos a la vista cenital
        cam.setLocation(new Vector3f(0, 100,0)); // Ajusta la altura para ver desde arriba
        cam.lookAt(Vector3f.ZERO, Vector3f.UNIT_Z); // Mirar hacia abajo (hacia el eje negativo Z)
    }
    topView = !topView; // Cambiar el estado de la vista
}

  /** We over-write some navigational key mappings here, so we can
   * add physics-controlled walking and jumping: */
  private void setUpKeys() {
    inputManager.addMapping("Left", new KeyTrigger(KeyInput.KEY_A));
    inputManager.addMapping("Right", new KeyTrigger(KeyInput.KEY_D));
    inputManager.addMapping("Up", new KeyTrigger(KeyInput.KEY_W));
    inputManager.addMapping("Down", new KeyTrigger(KeyInput.KEY_S));
    inputManager.addMapping("Jump", new KeyTrigger(KeyInput.KEY_SPACE));
    inputManager.addListener(this, "Left");
    inputManager.addListener(this, "Right");
    inputManager.addListener(this, "Up");
    inputManager.addListener(this, "Down");
    inputManager.addListener(this, "Jump");
    inputManager.addMapping("ToggleView", new KeyTrigger(KeyInput.KEY_V));
    inputManager.addListener(this, "ToggleView");
     // ... otras teclas ...
    inputManager.addMapping("Upward", new KeyTrigger(KeyInput.KEY_R)); // Tecla R para subir

    inputManager.addListener(this, "Upward");
    // ... otras teclas ...
    inputManager.addMapping("PrintMessage", new KeyTrigger(KeyInput.KEY_M));
    inputManager.addListener(this, "PrintMessage");
  }
  /** These are our custom actions triggered by key presses.
   * We do not walk yet, we just keep track of the direction the user pressed. */
  public void onAction(String binding, boolean value, float tpf) {
    if (binding.equals("Left")) {
      if (value) { left = true; } else { left = false; }
    } else if (binding.equals("Right")) {
      if (value) { right = true; } else { right = false; }
    } else if (binding.equals("Up")) {
      if (value) { up = true; } else { up = false; }
    } else if (binding.equals("Down")) {
      if (value) { down = true; } else { down = false; }
    } else if (binding.equals("Jump")) {
      player.jump();
    }// Detectar si se presiona la tecla V para cambiar entre vista normal y vista cenital
        if (binding.equals("ToggleView") && value) {
            toggleTopView();
        }
    if (binding.equals("Upward")) {
        if (value) {
            // Si se presiona la tecla, ajustamos la posición del jugador hacia arriba en el eje Z
            player.setPhysicsLocation(player.getPhysicsLocation().add(new Vector3f(0, 20f, 0f))); // Ajusta el valor 5f según sea necesario
        }
    }
    if (binding.equals("PrintMessage") && value) {
        // Si se presiona la tecla "M", imprimir el mensaje
        System.out.println("¡Mensaje impreso cuando se presionó el botón!");
        bandera = !bandera; // Cambiar el estado de la colisión
        if (bandera) {
            bulletAppState.getPhysicsSpace().add(landscape5);
        } else {
            bulletAppState.getPhysicsSpace().remove(landscape5);
        }
    }
  }


  /**
   * This is the main event loop--walking happens here.
   * We check in which direction the player is walking by interpreting
   * the camera direction forward (camDir) and to the side (camLeft).
   * The setWalkDirection() command is what lets a physics-controlled player walk.
   * We also make sure here that the camera moves with player.
   */

  @Override
    public void simpleUpdate(float tpf) {
        Vector3f camDir = cam.getDirection().clone().multLocal(0.2f);
        Vector3f camLeft = cam.getLeft().clone().multLocal(0.4f);
        walkDirection.set(0, 0, 0);
        if (left)  { walkDirection.addLocal(camLeft); }
        if (right) { walkDirection.addLocal(camLeft.negate()); }
        if (up)    { walkDirection.addLocal(camDir); }
        if (down)  { walkDirection.addLocal(camDir.negate()); }
        player.setWalkDirection(walkDirection);
        cam.setLocation(player.getPhysicsLocation());

        
    }
    
}