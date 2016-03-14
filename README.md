# BalloonFight

##Các thành viên trong Nhóm 1 - Gen3 - TechKids - Môn Lập trình hướng đối tượng CI
+ Giảng viên: Trần Đức Hùng
+ Nguyễn Trần Trung
+ Nguyễn Hường
+ Hoàng Dương
+ Khuất Anh Tuấn

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
int postionX;
int postionY;
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


##Công cụ phát triển
+ Phần mềm IntelliJ IDEA 15
