Create database casestudy;
use casestudy;

CREATE TABLE user (
    userName VARCHAR(16) PRIMARY KEY,
    email VARCHAR(255),
    Password VARCHAR(32) NOT NULL,
    create_time TIMESTAMP
);

CREATE TABLE Publish (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    email VARCHAR(255) NOT NULL,
    address VARCHAR(45)
);


INSERT INTO publish (name, email, address) VALUES
("GIAO DUC PUBLISHMENT","giao@giaoduc.vn","Ha Noi"),
("VAN HOC PUBLISHMENT","vanhoc@vanhoc","Ha Noi"),
( "KIMDONG PUBLISHMENT", "kimdongbook@kimdong.vn", "Ha Noi"),	
( "THOI DAI PUBLISHMENT", "timebook@timebook.vn", "Ha Noi"),
( "YOUNG PUBLISHMENT", "nxbtre@nxbtre.vn", "Ha Noi"),
( "HO CHi MINH PUBLISHMENT", "hcmbook@hcmbook.vn", "Ho Chi Minh"),
("NHA VAN MINH PUBLISHMENT","nhavan@nhavan.vn","Ha Noi"),
("THANH NIEN PUBLISHMENT","thanhnien@thanhnien.vn","Ha Noi"),
("CHINH TRI QUOC GIA PUBLISHMENT", "suthat@nxbctqg.vn", "Ha Noi");




CREATE TABLE author (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    address VARCHAR(45),
    email VARCHAR(45)
);

INSERT INTO author(name, address, email) VALUES
("Nguyen Nhat Anh", "HCM", "nhatanh@gmail.com"),
("Stuart Tan", "England",""),
("Margaret Mitchell", "american", ""),
("Jeffrey Archer","England", ""),
("Harriet Beecher Stowe", "american", ""),
("Antoine Galland", "A Rap", ""),


-- 'Science'
("stephen hawking","america","hawking@gmail.com"),
("bill bryson","america","hawking@gmail.com"),
("einstein","america","einstein@gmail.com"),
("paul","america","paul@gmail.com"),
("mukher jee","america","jee@gmail.com"),

-- 'Economic'

("henry hazlitt","america","henry@gmail.com"),
("levan","america","levitt@gmail.com"),
("Edition","america","Edit@gmail.com"),
("alan Greenspan","america","alan@gmail.com"),
("kate raworth","america","kate@gmail.com"),

-- 'Literature & Art'

("helen Gardner","america","helen@gmail.com"),
("phaidon","america","phaidon@gmail.com"),
("prestel","america","prerel@gmail.com"),
("Gothic","america","Gothic@gmail.com"),
("John berger","america","Gothic@gmail.com"),

-- 'Cultural & Historical' 

("Padraic","london","padraic@gmail.com"),
("Richard","america","richard@gmail.com"),
("Ned Palmer","British","ned@gmai.com"),
("Isaac donoso"," Philippine","isaac@gmail.com"),
("Marjorie Garber","italian","Garber@gmail.com"),

-- Children
("Nam Thanh", "Viet Nam",""),
("Matthew Barrie", "England",""),
("Lewis Caroll", "England", ""),
("Hans Christian Andersen", "denmark",""),

-- Mentality, Spirituality & Religion
("Khai Hung", "Viet Nam", ""),
("Chu Viet Nga", "Viet Nam", ""),
("Jules Verne", "France",""),
("Anagarika Govinda", "German",""),
("Eckhart Tolle", "German", ""),

-- Story & Novel
("Hector Malot", "France", ""),
("Harper Lee", "American", ""),
("Ernest Hemingway", "American",""),
("J. D. Salinger", "American", ""),
("Gabriel García Márquez", "Colombia", ""),


-- Curriculum
("Frank McCourt","american", ""),
("Todd Withtaker", "england", ""),
("Erin Gruwell", "american", ""),
("Fukuzawa Yukichi", "japan", ""),
("Edmondo De Amicis", "american", "");





CREATE TABLE positions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    describle VARCHAR(255),
    quantityLimit int default 10,
    quantity INT NOT NULL
);

insert into positions (name,describle,quantity) values
('Zone 1 North','floor 1', 2),
('Zone 1 East', 'floor 1', 8),
('Zone 1 West', 'floor 1', 9),
('Zone 1 South', 'floor 1', 7),
('Zone 1 Center', 'floor 1', 0),
('Zone 2 North','floor 2', 4),
('Zone 2 East', 'floor 2', 3),
('Zone 2 West', 'floor 2', 1),
('Zone 2 South', 'floor 2', 2),
('Zone 2 Center', 'floor 2', 10);



CREATE TABLE books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    describle TEXT,
    language VARCHAR(45),
    status ENUM('new', 'old') NOT NULL,
    type ENUM('Political & Law', 'Science', 'Economic', 'Literature & Art', 'Cultural & Historical', 'Curriculum', 'Story & Novel', 'Mentality, Spirituality & Religion', 'Children') NOT NULL,
    image VARCHAR(255) NOT NULL,
    yearPublish DATETIME,
    idPublish INT NOT NULL,
    idAuthor INT NOT NULL,
    idPosition INT NOT NULL,
    FOREIGN KEY (idPublish)
        REFERENCES publish (id),
    FOREIGN KEY (idAuthor)
        REFERENCES author (id),
    FOREIGN KEY (idPosition)
        REFERENCES positions (id)
);

    
    INSERT INTO books(name, describle, language, status, type,image, idpublish,idAuthor, idposition) 
VALUES 
-- Political & Law
("Toi Thay Hoa Vang Tren Co Xanh",  "Day la tac pham cua Nha van Nguyen Nhat Anh sang tac huong den lua tuoi thanh thieu nien xuat ban lan dau nam 2010", "VietNamese", "new", "Political & Law","https://upload.wikimedia.org/wikipedia/vi/f/f8/Toithayhoavangtrencoxanh.jpg", 1, 1,1),
("lam chu tu duy thay doi van menh","day la quyen sach","tieng anh","old","Political & Law",'https://sachnoi.com.vn/wp-content/uploads/2020/10/lam-chu-tu-duy-thay-doi-van-menh.jpg',1,2,1),
("cuon theo chieu gio ","day la quyen sach","tieng anh","old","Political & Law",'https://salt.tikicdn.com/cache/w1200/ts/product/a6/1e/c9/bb2b006d46f1c6c54f9c66eac99ca7ae.jpg',1,3,2),
("hai so phan","day la quyen sach","tieng anh","old","Political & Law",'https://bizweb.dktcdn.net/100/370/339/products/hai-so-phan.jpg?v=1611676664730',1,4,2),
("tup leu bac tom","day la quyen sach","tieng anh","old","Political & Law",'https://product.hstatic.net/1000237375/product/tup-leu-bac-tom-440_master.jpg',1,5,2),
("nghin le mot dem","day la quyen sach","tieng anh","old","Political & Law",'http://isach.info/images/story/cover/nghin_le_mot_dem__co_tich.jpg',1,6,2),

 
-- 'Science'
("lich su thoi gian","day la sach","tieng anh","new",'Science','https://readvii.com/wp-content/uploads/2019/12/sach-luoc-su-thoi-gian.png',2,7,2),
("lich su van vat","day la sach","tieng anh","new",'Science',"https://readvii.com/wp-content/uploads/2020/01/sach-luoc-su-van-vat.png",2,8,2),
("cuoc doi va vu tru","day la sach","tieng anh","new",'Science',"https://readvii.com/wp-content/uploads/2019/12/sach-einstein-cuoc-doi-va-vu-tru.png",2,9,2),
("kham pha cung nha khoa hoc","day la sach","tieng anh","new",'Science',"https://readvii.com/wp-content/uploads/2020/01/sach-te-bao-goc-kham-pha-cung-nha-khoa-hoc.png",2,10,2),
("lich su va tuong lai cua nhan loai","day la sach","tieng anh","new",'Science',"https://readvii.com/wp-content/uploads/2020/01/sach-gen-lich-su-va-tuong-lai-cua-nhan-loai.png",2,11,3),


-- 'Economic'

("economics one lesson","day la sach","tieng anh","new",'Economic',"https://unitrain.edu.vn/wp-content/uploads/2021/01/16.jpg",3,12,3),
("Freakonomics","day la sach","tieng anh","old",'Economic',"https://unitrain.edu.vn/wp-content/uploads/2021/01/17.jpg",3,13,3),
("Capitalism and Freem","day la sach","tieng anh","new",'Economic',"https://unitrain.edu.vn/wp-content/uploads/2021/01/18.jpg",3,14,3),
("capitalism in america","day la sach","tieng anh","new",'Economic',"https://unitrain.edu.vn/wp-content/uploads/2021/01/19-1.jpg",3,15,3),
("Doughnut Economics","day la sachs" ,"tieng anh","new",'Economic',"https://unitrain.edu.vn/wp-content/uploads/2021/01/20.jpg",3,16,3),

 
-- 'Literature & Art'
("art through the ages","day la sach","tieng anh","new",'Literature & Art',"https://mymodernmet.com/wp/wp-content/uploads/2018/05/best-art-history-books-1.jpg",4,17,3),
("the Art book","day la sach","tieng anh","new",'Literature & Art',"https://mymodernmet.com/wp/wp-content/uploads/2018/05/best-art-history-books-2.jpg",4,18,3),
("the Collins Big Book of Art","day la sach", "tieng anh","new",'Literature & Art',"https://mymodernmet.com/wp/wp-content/uploads/2018/06/art-history-books-update-2.jpg",4,19,3),
("50 Artists You Should Know","day la sach","tieng anh","new",'Literature & Art',"https://mymodernmet.com/wp/wp-content/uploads/2018/06/art-history-books-update-1.jpg",4,20,4),
("The Story Of Art","day la sach","tieng anh","old",'Literature & Art',"https://mymodernmet.com/wp/wp-content/uploads/2018/05/best-art-history-books-6.jpg",4,21,4),



-- 'Cultural & Historical',

("This Day in Irish History","day la sach","tieng anh","new",'Cultural & Historical',"https://m.media-amazon.com/images/I/51nlK1zyU8L._SL500_.jpg",5,22,4),
("Black Art","day la Sach","tieng anh","new",'Cultural & Historical',"https://m.media-amazon.com/images/I/41FqfBDY5mS._SL500_.jpg",5,23,4),
("Cheesemonger's History of the British Isles","day la sach","tieng anh","old",'Cultural & Historical',"https://m.media-amazon.com/images/I/41tLS9WJYrL._SL500_.jpg",5,24,4),
("More Islamic than We Admit","day la sach","tieng anh","new",'Cultural & Historical',"https://m.media-amazon.com/images/I/41TxP299HeL._SL500_.jpg",5,25,4),
("Character","day la sach","tieng anh","new",'Cultural & Historical',"https://m.media-amazon.com/images/I/41cxxZxVfHL.jpg",5,26,4),


   -- Children
("Ngoi nha cua ca con", "tap truyen bao gom nhieu chuyen dong thoai danh cho thieu nhi", "Vietnamese", "old","Children", "https://www.nxbtre.com.vn/Images/Book/NXBTreStoryFull_25472014_084755.jpg", 6, 27, 6),
("Bau vat cua nhai xanh", "tap truyen dong thoai, bao gom nhieu truyen ngan giao duc cac em long tu trong, oc sang tao, khong ich ky", "Vietnamese", "old","Children", "https://salt.tikicdn.com/cache/w1200/media/catalog/product/b/a/bau-vat-cua-nhai-xanh.jpg",6,27,6), 
("Peter Pan", "truyen hay danh cho thieu nhi", "english", "old","Children", "https://product.hstatic.net/200000017360/product/peter-pan-1_1700562c4f5e4a90934a7f9cf8ea93de.jpg", 6,28,6),
("Alice o xu so dieu ky", "truyen hay danh cho thieu nhi", "english", "old","Children","https://product.hstatic.net/1000186499/product/900x900_a231f67f8d7648bfa596fe472a194fe5_master.jpg",6,29,6),
("Co be ban diem",  "truyen hay danh cho thieu nhi", "Denmark" , "old","Children", "https://toplist.vn/images/800px/bai-van-hoa-than-vao-nhung-que-diem-ke-lai-cau-chuyen-co-be-ban-diem-ngu-van-8-hay-nhat-609162.jpg", 6,30,7),

  
-- "Mentality, Spirituality & Religion",

("Doi ban", "tieu thuyet hay", "Vietnamese", "new","Mentality, Spirituality & Religion", "https://quang.name.vn/wp-content/uploads/2020/05/doi-ban-nhat-linh.jpg", 7, 31, 7),
("Luot qua con mong", "tieu thuyet gay tram cam", "Vietnamese", "new","Mentality, Spirituality & Religion", "https://cdn0.fahasa.com/media/catalog/product/l/u/luot_qua_con_mong_1_2020_10_12_17_10_14.jpg", 7, 32, 7),
("80 ngay vong quanh the gioi", "tieu thuyet hay, hap dan", "french", "old","Mentality, Spirituality & Religion", "https://vnwriter.net/wp-content/uploads/2017/11/sach-80-ngay-vong-quanh-the-gioi.jpg", 7, 33, 8),
("Duong may qua xu tuyet", "sach hay dang xem","american", "old","Mentality, Spirituality & Religion", "https://www.netabooks.vn/Data/Sites/1/Product/2796/duong-may-qua-xu-tuyet-tai-ban-01.jpg", 7, 34, 9),
("Thuc tinh muc dich song", "day la mot cuon sach hay", "German", "old","Mentality, Spirituality & Religion", "https://www.dtv-ebook.com/images/files_2/2019/thuc-tinh-muc-dich-song-eckhart-tolle.jpg", 7, 35, 9),


-- "Story & Novel",
("khong gia dinh" , "tieu thuyet hay", "france", "old","Story & Novel", "https://cdn0.fahasa.com/media/flashmagazine/images/page_images/khong_gia_dinh_tri_viet_2018/2020_05_19_09_50_19_1-390x510.JPG",8 , 36, 10),
("giet con chim nhai", "tieu thuyet hay", "american", "old","Story & Novel", "https://salt.tikicdn.com/cache/w1200/ts/product/ea/57/9e/71ddae5c7ce50ab004c810849637576c.jpg",8, 37, 10),
("ong gia va bien ca", "tieu thuyet hay", "american", "old","Story & Novel", "https://bizweb.dktcdn.net/thumb/1024x1024/100/370/339/products/ong-gia-dinh-ti.jpg?v=1590076218870", 7, 38, 10),
("bat tre dong xanh", "day la mot tieu thuyet hay", "american", "old","Story & Novel", "https://upload.wikimedia.org/wikipedia/vi/b/b7/B%E1%BA%AFt_tr%E1%BA%BB_%C4%91%E1%BB%93ng_xanh%28s%C3%A1ch%29.jpg", 8, 39, 10),
("tram nam co don", "day la mot tieu thuyet hay", "colombia", "old","Story & Novel", "https://revelogue.com/wp-content/uploads/2020/04/tram-nam-co-don-anh-dai-dien.jpg", 4, 40, 10),


-- "Curriculum",
("nguoi thay", "day la cuon sach hay", "american", "old","Curriculum", "https://sachhaynendoc.net/wp-content/uploads/2019/11/Ng%C6%B0%E1%BB%9Di-th%E1%BA%A7y-%C4%91%E1%BA%A7u-ti%C3%AAn.jpg", 8, 41, 10),
("tinh thay tro", "day la cuon sach hay", "english", "old","Curriculum","https://photo-cms-plo.zadn.vn/w800/Uploaded/2022/yqjvzdjwp/2014_11_16/8-sachtinhthaytro_htub.jpg", 8, 42, 10),
("viet len hi vong", "day la cuon sach hay", "american", "old","Curriculum", "https://thaihabooks.com/wp-content/uploads/2021/06/Bia_Viet-len-hy-vong_resize-2-600x861.jpg", 8, 43, 10),
("khuyen hoc", "day la mot cuon sach hay", "japanese", "old","Curriculum", "https://salt.tikicdn.com/cache/w1200/media/catalog/product/k/h/khuyen-hoc.jpg",8 , 44, 10),
("nhung tam long cao ca", "day la cuon sach noi tieng the gioi", "Italian", "old","Curriculum", "http://isach.info/images/story/cover/nhung_tam_long_cao_ca__edmondo_de_amicis.jpg",8 , 45, 10);





CREATE TABLE customers (
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    email VARCHAR(45) NOT NULL,
    phone VARCHAR(45) NOT NULL
);



CREATE TABLE userCustomers (
    id VARCHAR(10) PRIMARY KEY,
    userName VARCHAR(45),
    password VARCHAR(45),
    email VARCHAR(45),
    idCustomer VARCHAR(10),
    FOREIGN KEY (idCustomer)
        REFERENCES customeres (id)
);

CREATE VIEW books_list as
SELECT books.id, books.name "Name Of Book", a.name "Author", books.describle "Describe", books.language "Language", books.status "Status", books.type "Type",
p.name "Publish", positions.name "Position", Year(books.yearPublish) "Year", books.image "Image"
FROM books 
JOIN author a ON a.id = books.idAuthor
JOIN publish p ON p.id = books.idPublish
JOIN positions ON positions.id = books.idPosition;

Select * From books_list
