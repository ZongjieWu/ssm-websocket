package com.wzj.utils;

// 阿里上传文件
public class aliossUtil {

//    // endpoint是访问OSS的域名。如果您已经在OSS的控制台上 创建了Bucket，请在控制台上查看域名。
//    // 如果您还没有创建Bucket，endpoint选择请参看文档中心的“开发人员指南 > 基本概念 > 访问域名”，
//    // 链接地址是：https://help.aliyun.com/document_detail/oss/user_guide/oss_concept/endpoint.html?spm=5176.docoss/user_guide/endpoint_region
//    // endpoint的格式形如“http://oss-cn-hangzhou.aliyuncs.com/”，注意http://后不带bucket名称，
//    // 比如“http://bucket-name.oss-cn-hangzhou.aliyuncs.com”，是错误的endpoint，请去掉其中的“bucket-name”。
//    private static String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
//
//    // accessKeyId和accessKeySecret是OSS的访问密钥，您可以在控制台上创建和查看，
//    // 创建和查看访问密钥的链接地址是：https://ak-console.aliyun.com/#/。
//    // 注意：accessKeyId和accessKeySecret前后都没有空格，从控制台复制时请检查并去除多余的空格。
//    private static String accessKeyId = "<yourAccessKeyId>";
//    private static String accessKeySecret = "<yourAccessKeySecret>";
//
//    // Bucket用来管理所存储Object的存储空间，详细描述请参看“开发人员指南 > 基本概念 > OSS基本概念介绍”。
//    // Bucket命名规范如下：只能包括小写字母，数字和短横线（-），必须以小写字母或者数字开头，长度必须在3-63字节之间。
//    private static String bucketName = "<yourBucketName>";
//
//    // Object是OSS存储数据的基本单元，称为OSS的对象，也被称为OSS的文件。详细描述请参看“开发人员指南 > 基本概念 > OSS基本概念介绍”。
//    // Object命名规范如下：使用UTF-8编码，长度必须在1-1023字节之间，不能以“/”或者“\”字符开头。
//    private static String firstKey = "my-first-key";
//
//    public static void main(String[] args) {
//
//
//        // 生成OSSClient，您可以指定一些参数，详见“SDK手册 > Java-SDK > 初始化”，
//        // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/init.html?spm=5176.docoss/sdk/java-sdk/get-start
//        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
//
//        try {
//
//            // 判断Bucket是否存在。详细请参看“SDK手册 > Java-SDK > 管理Bucket”。
//            // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/manage_bucket.html?spm=5176.docoss/sdk/java-sdk/init
//            if (ossClient.doesBucketExist(bucketName)) {
//                System.out.println("您已经创建Bucket：" + bucketName + "。");
//            } else {
//                System.out.println("您的Bucket不存在，创建Bucket：" + bucketName + "。");
//                // 创建Bucket。详细请参看“SDK手册 > Java-SDK > 管理Bucket”。
//                // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/manage_bucket.html?spm=5176.docoss/sdk/java-sdk/init
//                ossClient.createBucket(bucketName);
//            }
//
//            // 查看Bucket信息。详细请参看“SDK手册 > Java-SDK > 管理Bucket”。
//            // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/manage_bucket.html?spm=5176.docoss/sdk/java-sdk/init
//            BucketInfo info = ossClient.getBucketInfo(bucketName);
//            System.out.println("Bucket " + bucketName + "的信息如下：");
//            System.out.println("\t数据中心：" + info.getBucket().getLocation());
//            System.out.println("\t创建时间：" + info.getBucket().getCreationDate());
//            System.out.println("\t用户标志：" + info.getBucket().getOwner());
//
//            // 文件存储入OSS，Object的名称为fileKey。详细请参看“SDK手册 > Java-SDK > 上传文件”。
//            // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/upload_object.html?spm=5176.docoss/user_guide/upload_object
//            String fileKey = "README.md";
//            ossClient.putObject(bucketName, fileKey, new File("README.md"));
//            System.out.println("Object：" + fileKey + "存入OSS成功。");
//
//        } catch (OSSException oe) {
//            oe.printStackTrace();
//        } catch (ClientException ce) {
//            ce.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            ossClient.shutdown();
//        }
//    }

}
