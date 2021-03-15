package com.mhj.demo.stream;

import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.ColorModel;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.junit.Test;
import org.springframework.util.StreamUtils;

public class NormalTest {
	@Test
	public void testImage1() {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		try {
			StreamUtils.copy(new FileInputStream(new File("D:\\百度云盘\\200.png")), bytes);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] s = bytes.toByteArray();
		String hexStr = "0123456789ABCDEF", hex = "";
		for (int i = 0; i < s.length; i++) {
			hex += String.valueOf(hexStr.charAt((s[i] & 0xF0) >> 4));
			hex += String.valueOf(hexStr.charAt(s[i] & 0x0F));
		}
		System.out.println(hex);
		System.out.println(s.length);
	}

	@Test
	public void testImage() {
		// 每四个标识一个像素
		// System.out.println("F0F0F0F0F0F0F0F00F0F0F0F0F0F0F0FF0F0F0F0F0F0F0F00F0F0F0F0F0F0F0F".length());
		try {
			BufferedImage buffer = ImageIO.read(new File("D:\\百度云盘\\test.png"));
			ColorModel colorModel = buffer.getColorModel();
			// BufferedImage bufferedImage=new
			// ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY),null).filter
			// (buffer,null);

			// ImageIO.write(bufferedImage, "png", new
			// File("C:\\Users\\ET\\Desktop\\agile_logo11.png"));
			int _w = buffer.getWidth(), _h = buffer.getHeight();
			// BufferedImage image = new BufferedImage(_w, _h, BufferedImage.TYPE_INT_RGB);
			/*
			 * for (int i = 0; i < _w; i++) { for (int j = 0; j < _h; j++) { int c =
			 * buffer.getRGB(i,j); if(Math.abs(c) > 200) { image.setRGB(i, j, 0xFF000000); }
			 * else { image.setRGB(i, j, 0xFFFFFFFF); } System.out.println(c); } }
			 */
			int[] pixels = new int[_w * _h];
			byte[] bytes = new byte[_w * _h];
			PixelGrabber pg = new PixelGrabber(buffer, 0, 0, _w, _h, pixels, 0, _w);
			try {
				pg.grabPixels(); // 读取像素值
			} catch (InterruptedException e) {
				System.err.println("处理被异常中断！请重试！");
			}

			int width = _w;
			byte[] byt1 = bitmapToBWPix(_w, _h, pixels, bytes);
			int height = byt1.length / width;
			byte[] codecontent = pixToEscRastBitImageCmd(byt1);
			String data = this.toHexString1(codecontent);
			String str = "EG " + width / 8 + " " + height + " " + _w + " " + _h + " " + data + "\r\n";
			System.out.println(str);

			/*
			 * for (int i = 0; i < _w; i++) { for (int j = 0; j < _h; j++) {
			 * handlesinglepixel(pixels[j * _w + i]); } }
			 */

			// ImageIO.write(buffer, "bmp", new
			// File("C:\\Users\\ET\\Desktop\\agile_logo112.bmp"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static byte[] pixToEscRastBitImageCmd(byte[] src) {
		byte[] data = new byte[src.length / 8];
		int i = 0;

		for (int k = 0; i < data.length; ++i) {
			data[i] = (byte) (p0[src[k]] + p1[src[k + 1]] + p2[src[k + 2]] + p3[src[k + 3]] + p4[src[k + 4]]
					+ p5[src[k + 5]] + p6[src[k + 6]] + src[k + 7]);
			k += 8;
		}

		return data;
	}

	private static int[] p0 = new int[] { 0, 128 };
	private static int[] p1 = new int[] { 0, 64 };
	private static int[] p2 = new int[] { 0, 32 };
	private static int[] p3 = new int[] { 0, 16 };
	private static int[] p4 = new int[] { 0, 8 };
	private static int[] p5 = new int[] { 0, 4 };
	private static int[] p6 = new int[] { 0, 2 };

	public void handlesinglepixel(int pixel) {
		int alpha = (pixel >> 24) & 0xff;
		int red = (pixel >> 16) & 0xff;
		int green = (pixel >> 8) & 0xff;
		int blue = (pixel) & 0xff;
		// Deal with the pixel as necessary...
		System.out.println(alpha + "--" + red + "--" + green + "--" + blue + "--");
	}

	public static byte[] bitmapToBWPix(int w, int h, int[] pixels, byte[] data) {
		format_K_dither16x16(pixels, w, h, data);
		return data;
	}

	public String toHexString1(byte[] b) {
		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < b.length; ++i) {
			buffer.append(this.toHexString2(b[i]));
		}

		return buffer.toString();
	}

	public String toHexString2(byte b) {
		String s = Integer.toHexString(b & 255);
		return s.length() == 1 ? "0" + s.toUpperCase() : s.toUpperCase();
	}

	private static int[][] Floyd16x16 = new int[][] {
			{ 0, 128, 32, 160, 8, 136, 40, 168, 2, 130, 34, 162, 10, 138, 42, 170 },
			{ 192, 64, 224, 96, 200, 72, 232, 104, 194, 66, 226, 98, 202, 74, 234, 106 },
			{ 48, 176, 16, 144, 56, 184, 24, 152, 50, 178, 18, 146, 58, 186, 26, 154 },
			{ 240, 112, 208, 80, 248, 120, 216, 88, 242, 114, 210, 82, 250, 122, 218, 90 },
			{ 12, 140, 44, 172, 4, 132, 36, 164, 14, 142, 46, 174, 6, 134, 38, 166 },
			{ 204, 76, 236, 108, 196, 68, 228, 100, 206, 78, 238, 110, 198, 70, 230, 102 },
			{ 60, 188, 28, 156, 52, 180, 20, 148, 62, 190, 30, 158, 54, 182, 22, 150 },
			{ 252, 124, 220, 92, 244, 116, 212, 84, 254, 126, 222, 94, 246, 118, 214, 86 },
			{ 3, 131, 35, 163, 11, 139, 43, 171, 1, 129, 33, 161, 9, 137, 41, 169 },
			{ 195, 67, 227, 99, 203, 75, 235, 107, 193, 65, 225, 97, 201, 73, 233, 105 },
			{ 51, 179, 19, 147, 59, 187, 27, 155, 49, 177, 17, 145, 57, 185, 25, 153 },
			{ 243, 115, 211, 83, 251, 123, 219, 91, 241, 113, 209, 81, 249, 121, 217, 89 },
			{ 15, 143, 47, 175, 7, 135, 39, 167, 13, 141, 45, 173, 5, 133, 37, 165 },
			{ 207, 79, 239, 111, 199, 71, 231, 103, 205, 77, 237, 109, 197, 69, 229, 101 },
			{ 63, 191, 31, 159, 55, 183, 23, 151, 61, 189, 29, 157, 53, 181, 21, 149 },
			{ 254, 127, 223, 95, 247, 119, 215, 87, 253, 125, 221, 93, 245, 117, 213, 85 } };

	private static void format_K_dither16x16(int[] orgpixels, int xsize, int ysize, byte[] despixels) {
		int k = 0;

		for (int y = 0; y < ysize; ++y) {
			for (int x = 0; x < xsize; ++x) {
				if ((orgpixels[k] & 255) > Floyd16x16[x & 15][y & 15]) {
					despixels[k] = 0;
				} else {
					despixels[k] = 1;
				}

				++k;
			}
		}

	}

	@Test
	public void testURlencode() {
		String orgId = "wxf88d5af8fece756b";
		String k = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + orgId + "&redirect_uri=";
		try {
			String a = URLEncoder.encode("http://yunagile.com:8083/demo/a/b?", "utf-8");
			k = k + a;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		k += "&response_type=code&scope=snsapi_base&state=#wechat_redirect";
		System.out.println(k);
	}

	@Test
	public void test1() {
		byte[] ss = new byte[1];
		System.out.println(ss.getClass().getName());
	}

	@Test
	public void test2() {
		String a = "'a\\'dd'";

		System.out.println(a);
	}

	@Test
	public void test3() {
		String a = "faddress like '%%s%'";
		a = a.replace("%s", "#_as_#").replace("%", "$_as_$").replace("#_as_#", "%s");
		System.out.println(String.format(a, 11.11).replace("$_as_$", "%"));
	}

	@Test
	public void test4() {
		String a = "fadd%sress like '%%s%'";


		Pattern ptn = Pattern.compile("%s");
		Matcher mat = ptn.matcher(a);
		while (mat.find()) {
			System.out.println(mat.start());
		}
	}
}
