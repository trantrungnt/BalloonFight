# BalloonFight

##Các thành viên trong Nhóm 1 - Gen3 - TechKids - Môn Lập trình hướng đối tượng CI
+ Giảng viên: Trần Đức Hùng
+ [Nguyễn Trần Trung](https://github.com/trantrungnt)
+ [Nguyễn Hường](https://github.com/HuongNguyen0706)
+ [Hoàng Dương] (https://github.com/hoangduong97)
+ [Khuất Anh Tuấn](https://github.com/tuancon5158)

##Các công việc cần làm:
+ Có được tài nguyên gồm: ảnh, file âm thanh cho game
+ Chọn bàn 2 trong Game Balloon Fight để code
+ Liệt kê các class và định nghĩa class của các Nhân vật, Quân địch, Map ... (dự kiến: GameObject, Figure, FigureEnemy, Cloud, Amination, Score ..)
+ Định nghĩa class Amination để tạo ảnh động trong Game
+ Xử lý hành động nổ bóng
+ Xử lý khi nhân vật bên mình bị nổ bóng và rơi xuống nước
+ Xử lý khi nhân vật bên địch bị nổ bóng và rơi xuống nước
+ Xử lý bóng bay khi nhấn nút lên, xuống, sang trái, sang phải (cho bóng bay hợp lý)
+ Xử lý âm thanh: khi bóng nổ thì âm thanh load vào và xử lý thế nào?
+ Xử lý âm thanh: khi rơi xuống nước thì load vào và  xủ lý thế nào?

##Quy tắc đặt tên biến, tên hằng số
+ Tên biến đặt theo kiểu gợi nhớ dễ hiểu và theo dạng dưới: 
```
private int positionX;
private int positionY;
```

+ Tên hằng số viết hoa và ghi rõ của đối tượng nào? Nên lưu các Hằng số ra 1 file Helper.java riêng để gọi ra và đọc cho dễ hiểu (hằng số ghi trong file đó nhớ comment dùng để làm gì). Tham khảo như ví dụ dưới:
```
public class Helper {
    public static final int WIDTH = 600; // chieu rong Window
    public static final int HEIGHT = 800; // Chieu cao Window
    public static final int PLANE_SIN_DELAY = 120;// = 2s thi 1 may bay moi xuat hien
    public static final int PIC_PLANE_WIDTH = 30; // chieu rong anh may bay Plane
    public static final int PIC_PLANE_HEIGT = 80;
    public static final int BULLET_SPEED = 20; // toc do dan Plane
    public static final int ENEMY_BULLET_SPEED = 1;
    public static final int SHOT_DELAY = 120; // = 2s thi ban 1 lan
}
```

+ Tên class nhớ viết hoa ký tự đầu tiên
```
public abstract class GameObject{
}
```

+ Tên của phương thức viết bình thường (nhớ comment phương thức này để làm gì)
```
//phuong thuc nay de di chuyen ngau nhien
public void move(){
        this.positionX += random(-3,3);
        this.positionY += random(-3,3);
    }
```

+ Xử lý Bơm bóng khi hiển thị ảnh địch Bơm bóng 1 lúc, sau đó hiển thị địch khi Bay
```
//Trong claas Enemy định nghĩa con trỏ Amination currentAmination
 private Animation animationCurrent{;
    private Animation animationBomBong;
    private Animation animationBayMotBong;
    private Animation animationBayHaiBong;
    private Animation animationBayVoiDu;
 }

 //khi draw trong class Enemy thi tro lai (dung bien tham chieu currentAmination)
public void draw(Graphics g){
        animationCurrent.draw(g, this.flip1, this.positionY, this.flip2, this.getSprite().getHeight());
    }

//trong phuong thuc update, check thoi gian Bom bong la 60 lan/ giay
 public void update() {
        //check thoi gian bom bong
        count++;
        if (count>=60) {
            animationCurrent = getEnemyAminationFly();
            this.move();
        }
    }
```

##Cách thêm thư viện JLayer vào Project
+ Trong thư mục hiện tại của project có thư mục library chứa file jl1.0.1.jar
+ Trong bộ công cụ IntelJi, vào File, chọn Project Structure. Sau đó, chọn Modules --> Nhìn bên phải màn hình chọn tab Dependencies và nhấn dấu + => tiếp đến chọn 1.Jar or directories ..và tìm file jl1.0.1.jar trong thư mục library trong project Balloon Fight và nhấn ok là sử dụng thư viện bình thường

##Công cụ phát triển
+ Phần mềm IntelliJ IDEA 15

##Tham khảo
+ [Trang Convert file online từ mp3 sang wav](https://convertio.co/mp3-wav/)
+ [Tham khảo dùng JavaX để đọc định dạng file sound: wav, au, aiff](https://www3.ntu.edu.sg/home/ehchua/programming/java/J8c_PlayingSound.html)

