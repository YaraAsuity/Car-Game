package javaapplication6;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;

public class Render {
    private static float red = 1 ; 
    private static float green = 1 ;
    private static float blue = 1 ;
    private static float alpha = 1 ;
    private static float rotation = 0 ;
    
	private static GLWindow window = null;
	public static int screenWidth = 640;
	public static int screenHeight = 560;
	public static float unitsWide = 10;
        public static GLProfile profile ; 
	public static float unitsTall = screenHeight / (float) screenWidth * unitsWide;
        
        
        public static void init() {
		GLProfile.initSingleton();
		profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities caps = new GLCapabilities (profile);
		window = GLWindow.create(caps);
		window.setSize(screenWidth, screenHeight);
		window.setResizable(true);
		window.addGLEventListener(new EventListener());
		
                window.addKeyListener(new Keyinput());
		window.setVisible(true);
		FPSAnimator animator = new FPSAnimator(window, 60);
		animator.start();
                
    
            }
	public static int getWindowWidth() {
		return window.getWidth();
	}
	public static int getWindowHeight() {
		return window.getHeight();
	}
        public static void setRotation(float r){
        rotation = r ;
    }
	public static void main(String[] args) {
		init();
	}
}