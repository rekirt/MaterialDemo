package com.example.lc.materialdemo.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import java.lang.reflect.Method;

/**
 *
 * @Author lc++
 */
public class ScreenUtil {
	
	private ScreenUtil(){
		throw new UnsupportedOperationException("can not be instantiated");
	}
	
	/**
	 * 
	* @Method: getScreenWidth 
	* @Description:  获取屏幕宽度
	* @param context
	* @return
	 */
	public static int getScreenWidth(Context context){
		WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics outMetrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(outMetrics);
		return outMetrics.widthPixels;
	}
	
	/**
	 * 
	* @Method: getScreenHeight 
	* @Description: 获取屏幕高度,
	* @param context
	* @return
	 */
	public static int getScreenHeight(Context context){
		WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics outMetrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(outMetrics);
		return outMetrics.heightPixels;
	}

	/**
	 * 获取屏幕真实高度
	 * @param context
	 * @return
     */
	public static int getRealScreenHeight(Context context){
		int dpi = 0;
		WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		Display display = windowManager.getDefaultDisplay();
		DisplayMetrics displayMetrics = new DisplayMetrics();
		Class c;
		try {
			c = Class.forName("android.view.Display");
			Method method = c.getMethod("getRealMetrics",DisplayMetrics.class);
			method.invoke(display, displayMetrics);
			dpi=displayMetrics.heightPixels;
		}catch(Exception e){
			e.printStackTrace();
		}
		return dpi;
	}
	/**
	 * 
	* @Method: getStatusHeight 
	* @Description: 获取状态栏高度 
	* @param context
	* @return
	 */
	public static int getStatusHeight(Context context){
		int statusHeight = -1;
		try {
			Class<?> clazz = Class.forName("com.android.internal.R$dimen");
			Object object = clazz.newInstance();
			int height = Integer.parseInt(clazz.getField("status_bar_height").get(object).toString());
			statusHeight = context.getResources().getDimensionPixelSize(height);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statusHeight;
	}

	/**
	 * 获取 虚拟按键的高度
	 * @param context
	 * @return
	 */
	public static int getBottomStatusHeight(Context context){
		return getRealScreenHeight(context) - getScreenHeight(context);
	}

	/**
	 * 
	* @Method: getScreenDensity 
	* @Description: 获取设备密度 
	* @param context
	* @return
	 */
	public static float getScreenDensity(Context context){
		WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics outMetrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(outMetrics);
		return outMetrics.density;
	}

	/**
	 *
	 * @Method: getScreenDensity
	 * @Description: 获取设备密度
	 * @param context
	 * @return
	 */
	public static float getScreenDensityDpi(Context context){
		WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics outMetrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(outMetrics);
		return outMetrics.densityDpi;
	}

	/**
	 * 
	* @Method: dp2px 
	* @Description:根据手机的分辨率从 dp 的单位 转成为 px(像素)   
	* @param dp
	* @return
	 */
	public static int dp2px(int dp,Context context){
		return (int)(dp*getScreenDensity(context)+0.5f);
	}
	
	/**
	 * 
	* @Method: px2dp 
	* @Description:根据手机的分辨率从 px(像素) 的单位 转成为 dp
	* @param px
	* @return
	 */
	public static int px2dp(int px,Context context){
		return (int)(px/getScreenDensity(context)+0.5f);
	}

	/**
	 *
	 * @Method: getScreenScaledDensity
	 * @Description: 获取设备密度
	 * @param context
	 * @return
	 */
	public static float getScreenScaledDensity(Context context){
		WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics outMetrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(outMetrics);
		return outMetrics.scaledDensity;
	}

	/**
	 * 将px值转换为sp值，保证文字大小不变
	 *
	 * @param pxValue
	 *            （DisplayMetrics类中属性scaledDensity）
	 * @return
	 */
	public static int px2sp(float pxValue, Context context) {
		return (int) (pxValue / getScreenScaledDensity(context) + 0.5f);
	}

	/**
	 * 将sp值转换为px值，保证文字大小不变
	 *
	 * @param spValue
	 *            （DisplayMetrics类中属性scaledDensity）
	 * @return
	 */
	public static int sp2px(float spValue, Context context) {
		return (int) (spValue * getScreenScaledDensity(context) + 0.5f);
	}

	/**
	 * 
	* @Method: snapShotWithStatusBar 
	* @Description:  获取当前屏幕截图，包含状态栏
	* @param activity
	* @return
	 */
	public static Bitmap snapShotWithStatusBar(Activity activity){
		View view = activity.getWindow().getDecorView();
		view.setDrawingCacheEnabled(true);
		view.buildDrawingCache();
		Bitmap bmp = view.getDrawingCache();
		int height = getScreenHeight(activity);
		int width = getScreenWidth(activity);
		Bitmap bm = Bitmap.createBitmap(bmp, 0, 0, width, height);
		view.destroyDrawingCache();
		return bm;
	}
	
	/**
	 * 
	* @Method: snapShotWithOutStatusBar 
	* @Description: 获取当前屏幕截图，不包含状态栏 
	* @param activity
	* @return
	 */
	public static Bitmap snapShotWithOutStatusBar(Activity activity){
		View view = activity.getWindow().getDecorView();
		view.setDrawingCacheEnabled(true);
		view.buildDrawingCache();
		Bitmap bmp = view.getDrawingCache();
		int width = getScreenWidth(activity);
		int height = getScreenHeight(activity);
		Rect frame = new Rect();
		view.getWindowVisibleDisplayFrame(frame);
		int statusHeight = frame.top;//状态栏高度
		Bitmap bm = Bitmap.createBitmap(bmp, 0, statusHeight, width, height-statusHeight);
		view.destroyDrawingCache();
		return bm;
	}
	
}
