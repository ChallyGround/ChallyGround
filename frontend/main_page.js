document.addEventListener('DOMContentLoaded', () => {
    // 슬라이더 관련 변수와 요소들
    const slides = document.querySelectorAll('.slide');
    const prevButton = document.querySelector('.slider-button.prev');
    const nextButton = document.querySelector('.slider-button.next');
    const slideInfo = document.querySelector('.slider-info');
    let currentSlide = 0;

    // 현재 슬라이드를 표시하는 함수
    function showSlide(index) {
        slides.forEach((slide, i) => {
            slide.style.display = i === index ? 'block' : 'none';
        });
        slideInfo.textContent = `${index + 1} / ${slides.length}`; // 슬라이드 정보 업데이트
    }

    // 다음 슬라이드를 표시하는 함수
    function nextSlide() {
        currentSlide = (currentSlide + 1) % slides.length;
        showSlide(currentSlide);
    }

    // 이전 슬라이드를 표시하는 함수
    function prevSlide() {
        currentSlide = (currentSlide - 1 + slides.length) % slides.length;
        showSlide(currentSlide);
    }

    // 초기 슬라이드 표시 및 자동 슬라이드 변경 설정
    showSlide(currentSlide);
    setInterval(nextSlide, 2000); // 2초마다 슬라이드 변경

    // 버튼 클릭 이벤트 핸들러
    prevButton.addEventListener('click', prevSlide);
    nextButton.addEventListener('click', nextSlide);

    // 카테고리 메뉴 관련 변수와 함수
    const categoryMenu = document.getElementById('category-menu');
    const categoryButton = document.getElementById('category');

    // 카테고리 메뉴 토글 함수
    function toggleCategoryMenu() {
        categoryMenu.style.display = categoryMenu.style.display === 'block' ? 'none' : 'block';
    }

    // 카테고리 메뉴 숨김 함수
    function hideCategoryMenu() {
        categoryMenu.style.display = 'none';
    }

    // 카테고리 버튼 클릭 이벤트 핸들러
    categoryButton.addEventListener('click', (event) => {
        event.stopPropagation(); // 클릭 이벤트가 상위 요소로 전파되지 않도록 막음
        toggleCategoryMenu();
    });

    // 카테고리 메뉴 외의 클릭으로 메뉴 닫기
    window.addEventListener('click', (event) => {
        if (!categoryMenu.contains(event.target) && event.target !== categoryButton) {
            hideCategoryMenu();
        }
    });

    // 카테고리 헤더 클릭 시 소분류 토글
    document.querySelectorAll('.category-header').forEach(header => {
        header.addEventListener('click', function () {
            const subcategory = this.nextElementSibling;
            subcategory.style.display = subcategory.style.display === 'block' ? 'none' : 'block';
        });
    });

    // 카테고리 항목 클릭 시 기본 동작 방지 및 페이지 이동
    document.querySelectorAll('.category-item a').forEach(link => {
        link.addEventListener('click', (event) => {
            event.preventDefault();
            window.location.href = link.getAttribute('href');
        });
    });

    // 네비게이션 항목 클릭 시 활성화 및 페이지 이동
    document.querySelectorAll('.nav-item').forEach(item => {
        item.addEventListener('click', function () {
            document.querySelectorAll('.nav-item').forEach(el => el.classList.remove('active'));
            this.classList.add('active');
            switch (this.id) {
                case 'home':
                    window.location.href = 'main_page.html';
                    break;
                case 'popular':
                    window.location.href = 'popular_page.html';
                    break;
                case 'new':
                    window.location.href = 'new_page.html';
                    break;
                case 'category':
                    toggleCategoryMenu();
                    break;
            }
        });
    });

    // 챌린지 업로드 버튼 클릭 시 페이지 이동
    document.getElementById('challenge-upload').addEventListener('click', () => {
        window.location.href = 'challenge_upload.html';
    });

    // 로그인/회원가입 버튼 클릭 시 페이지 이동
    document.getElementById('login-signup').addEventListener('click', () => {
        window.location.href = 'login_signup.html';
    });

    // 하트 버튼 클릭 시 즐겨찾기 상태 토글
    document.querySelectorAll('.favorite-btn').forEach(button => {
        button.addEventListener('click', (event) => {
            event.stopPropagation(); // 클릭 이벤트가 상위 요소로 전파되지 않도록 막음
            const isFavorite = button.getAttribute('data-favorite') === 'true';
            button.setAttribute('data-favorite', !isFavorite);
            button.style.color = isFavorite ? '#aaa' : '#e74c3c'; // 색상 변경
        });
    });

    // 챌린지 항목 클릭 시 해당 페이지로 이동
    document.querySelectorAll('.challenge-item').forEach(item => {
        item.addEventListener('click', () => {
            const challengeUrl = item.getAttribute('data-url'); // 각 챌린지 항목에 URL을 data-attribute로 저장
            if (challengeUrl) {
                window.location.href = challengeUrl;
            }
        });
    });

    // 현재 시간 표시 함수
    function updateCurrentTime() {
        const now = new Date();
        const formattedTime = now.getFullYear() + '.' +
            String(now.getMonth() + 1).padStart(2, '0') + '.' +
            String(now.getDate()).padStart(2, '0') + '.' +
            String(now.getHours()).padStart(2, '0') + ':' +
            String(now.getMinutes()).padStart(2, '0');
        document.querySelector('.current-time').textContent = formattedTime;
    }

    updateCurrentTime(); // 초기 현재 시간 표시
    setInterval(updateCurrentTime, 60000); // 매 분마다 현재 시간 업데이트

    // 카테고리 메뉴의 대분류와 소분류를 동적으로 추가하는 함수
    function populateCategoryMenu() {
        const categories = {
            '대분류1': ['소분류1-1', '소분류1-2'],
            '대분류2': ['소분류2-1', '소분류2-2'],
            '대분류3': ['소분류3-1', '소분류3-2'],
        };

        const menu = document.getElementById('category-menu');
        menu.innerHTML = ''; // 기존 내용을 지움

        for (const [mainCategory, subCategories] of Object.entries(categories)) {
            const section = document.createElement('div');
            section.className = 'category-section';

            const header = document.createElement('div');
            header.className = 'category-header';
            header.textContent = mainCategory;
            section.appendChild(header);

            const subcategoryList = document.createElement('div');
            subcategoryList.className = 'subcategory';

            subCategories.forEach(subCategory => {
                const item = document.createElement('a');
                item.className = 'category-item';
                item.href = '#'; // 실제 링크로 변경
                item.innerHTML = `<img src="path_to_image.jpg" alt="${subCategory}"><span>${subCategory}</span>`;
                subcategoryList.appendChild(item);
            });

            section.appendChild(subcategoryList);
            menu.appendChild(section);
        }
    }

    populateCategoryMenu(); // 카테고리 메뉴를 채웁니다
});
