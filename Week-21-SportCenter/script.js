

// Classes kısmında tıklanan başlığa göre content getirmek için
function showContent(contentType) {
  console.log("showContent called with contentType:", contentType);

  // Tüm içerikleri gizle
  var contents = document.querySelectorAll('.content-container');
  contents.forEach(function(content) {
    content.style.display = 'none';
  });

  // Aktif butonu sıfırla
  var buttons = document.querySelectorAll('.class-button');
  buttons.forEach(function(button) {
    button.classList.remove('active');
  });

  // İlgili içeriği göster
  var contentToShow = document.getElementById(contentType + 'Content');
  console.log("contentToShow:", contentToShow);
  var activeButton = document.querySelector('button[class="class-button"][onclick="showContent(\'' + contentType + '\')"]');
  console.log("activeButton:", activeButton);
  if (contentToShow && activeButton) {
    contentToShow.style.display = 'flex';
    if (window.innerWidth <= 600) {
      contentToShow.style.flexDirection = 'column';
    }
  }

    activeButton.classList.add('active'); // Aktif butona .active sınıfını ekle
  } 




// Enter tuşuna basıldığında BMI hesaplamasını başlat
document.addEventListener('keydown', function(event) {
  if (event.key === 'Enter') {
    calculateBMI();
  }
});

// BMI hesaplama fonksiyonu
function calculateBMI() {
  // Kullanıcının girdiği kilo ve boy değerlerini al
  var heightInput = document.getElementById('height').value;
  var weightInput = document.getElementById('weight').value;

  // Geçerli bir giriş olduğundan emin ol
  if (heightInput && weightInput) {
    // BMI hesapla
    var heightInMeters = parseFloat(heightInput) / 100; // Cm'yi metre cinsine dönüştür
    var weightInKg = parseFloat(weightInput);
    var bmi = weightInKg / (heightInMeters * heightInMeters);

    // BMI sonucunu ekrana yazdır
    var bmiResultElement = document.getElementById('bmiResult');
    bmiResultElement.textContent = 'Your BMI: ' + bmi.toFixed(2);

    // Vücut tipi resmindeki oku güncelle
    updateArrow(bmi);
 
}
}

// Vücut tipi resmindeki oku güncellemek için
function updateArrow(bmi) {
  var arrowElement = document.getElementById('arrow');
  var imageWidth = document.querySelector('.bmi-img-box').offsetWidth;

  // Okun hareket edeceği aralıkları ve pozisyonları hassas belirlemek için
  var positions = [
    { minBmi: 0, maxBmi: 18.4, leftPercentage: 20 },
    { minBmi: 18.5, maxBmi: 20, leftPercentage: 25 },
    { minBmi: 20.1, maxBmi: 22, leftPercentage: 35 },
    { minBmi: 22.1, maxBmi: 24, leftPercentage: 35 },
    { minBmi: 24.1, maxBmi: 26, leftPercentage: 45 },
    { minBmi: 26.1, maxBmi: 28, leftPercentage: 55 },
    { minBmi: 28.1, maxBmi: 30, leftPercentage: 55 },
    { minBmi: 30.1, maxBmi: 32, leftPercentage: 65 },
    { minBmi: 32.1, maxBmi: 34, leftPercentage: 70 },
    { minBmi: 34.1, maxBmi: Infinity, leftPercentage: 90 }
  ];

  // BMI değerine göre oku hareket ettirmek
  for (var i = 0; i < positions.length; i++) {
    var position = positions[i];
    if (bmi >= position.minBmi && bmi <= position.maxBmi) {
      var leftPosition = (position.leftPercentage / 100) * imageWidth;
      arrowElement.style.left = leftPosition + 'px';
      break;
    }
  }
}



window.addEventListener('scroll', () => {
  const verticalScrollPx = window.scrollY || window.pageYOffset;

  if (verticalScrollPx < 200) {
    document.getElementById("navbar").style.backgroundColor = 'transparent';
  } else {
    document.getElementById("navbar").style.backgroundColor = '#325493';
  } 
});




document.addEventListener('DOMContentLoaded', function() {
  // Mobil menü simgesine tıklandığında menüyü aç/kapat
  document.querySelector('.mobile-menu-icon').addEventListener('click', function(event) {
    // Mobil menüyü aç veya kapat
    const mobileMenu = document.querySelector('.mobile-menu');
    mobileMenu.classList.toggle('open');

    
    event.stopPropagation();
  });

  // Dışarıya tıklandığında menüyü kapat
  document.addEventListener('click', function(event) {
    const mobileMenu = document.querySelector('.mobile-menu');
    const mobileMenuIcon = document.querySelector('.mobile-menu-icon');
    const isClickInsideMenu = mobileMenu.contains(event.target);
    const isClickInsideMenuIcon = mobileMenuIcon.contains(event.target);

    if (!isClickInsideMenu && !isClickInsideMenuIcon) {
      mobileMenu.classList.remove('open');
    }
  });
});


