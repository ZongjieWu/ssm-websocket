package com.wzj.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 二维码生成
 */
public class qcUril {

    private static Logger logger = LoggerFactory.getLogger(qcUril.class);
//
//    private static int index =1;
//
//    //main方法，方法的入口
//    public static void main(String[] args) {
//        String str1 = "贼坑";
//        File dstfile1 = new File("E:\\logtest");
//
//        try {
//            createQRCode(str1, dstfile1);
//            //createQRCode(str2, dstfile1);
//            //createQRCode(str3, dstfile1);
//        } catch (WriterException | IOException e) {
//            e.printStackTrace();
//        }
//
//        //createLogoQRCode(new File("E:\\logtest\\logo.jpg"), str1,dstfile1 );
//    }
//
//    //专门用于生成二维码的工具方法
//    private static void createQRCode(String str ,File dst) throws WriterException, IOException{
//        //该类用于多种格式二维码的编码
//        MultiFormatWriter writer = new MultiFormatWriter();
//        //用来设置二维码的宽高
//        int width = 200;
//        int height = 200;
//        //用来设置二维码的一些属性
//        HashMap<EncodeHintType,Object> hints = new HashMap<>();
//        hints.put(EncodeHintType.CHARACTER_SET,"utf-8");
//        //用来编写二维码,返回二进制矩阵数据
//        BitMatrix bitmatrix = writer.encode(str, BarcodeFormat.QR_CODE, width, height,hints);
//        //三个参数，二进制矩阵数组，图片的格式，图片保存的路径
//        MatrixToImageWriter.writeToPath(bitmatrix,"png",new File(dst.getPath()+"/"+(index++)+".png").toPath());
//    }
//
//    //利用二维码容错机制生成一个简单的logo的工具方法,三个参数分别是目标图片,想要展示的内容,二维码存放地址
//    private static void createLogoQRCode(File dstimg,String str,File dst){
//
//        //该类用于多种格式二维码的编码
//        MultiFormatWriter writer = new MultiFormatWriter();
//        //用来设置二维码的宽高
//        int width = 200;
//        int height = 200;
//        //用来设置二维码的一些属性
//        HashMap<EncodeHintType,Object> hints = new HashMap<>();
//        hints.put(EncodeHintType.CHARACTER_SET,"utf-8");
//        //用来编写二维码,返回二进制矩阵数据
//        BitMatrix bitmatrix = null;
//        try {
//            bitmatrix = writer.encode(str,BarcodeFormat.QR_CODE, width, height,hints);
//        } catch (WriterException e1) {
//            e1.printStackTrace();
//        }
//
//        //创建图片,宽，高，
//        BufferedImage qr = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
//
//        for(int x=0;x<width;x++){
//            for(int y=0;y<height;y++){
//                if(bitmatrix.get(x, y)){//如果矩阵数组中有点的话,可以设置任意颜色
//                    qr.setRGB(x, y, 0xff0000);
//                }else{
//                    qr.setRGB(x, y, 0xffffff);
//                }
//            }
//        }
//
//        Image logoUse = null;
//        //将logo缩小，宽，高，缩小方式
//        int logoW=30;
//        int logoH=30;
//        try {
//            //读取logo
//            BufferedImage logoImg = ImageIO.read(dstimg);
//            logoUse = logoImg.getScaledInstance(logoW,logoH, Image.SCALE_FAST);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        //获取画笔
//        Graphics g = qr.getGraphics();
//        //绘制Logo,x坐标，y坐标
//        int logoX = (width-logoW)/2;
//        int logoY = (height-logoH)/2;
//
//        g.drawImage(logoUse,logoX,logoY, null);
//
//        try {
//            ImageIO.write(qr, "png",new File(dst.getPath()+"/"+(index++)+".png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//

    public static void main(String[] args) {
        logger.info("ssss");
    }
}
