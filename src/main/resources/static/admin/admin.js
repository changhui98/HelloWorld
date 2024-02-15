let header = document.querySelector('header'),
    nav = document.querySelector('nav');

     nav.addEventListener('mouseover', function(){
        header.style.height = '220px';
     });

     nav.addEventListener('mouseout', function(){
        header.style.height = '50px';
     });

/* 아래 코드는 먹지 않음.  */

let mainMenuList = document.querySelectorAll('.mainmenu > li'),
    subMenu = document.querySelectorAll('.submenu'),
    headerHeight = header.offsetHeight,
    subMenuHeight = 0;

    for(let i = 0; i< subMenu.length; i++){
        if(subMenu[i].offsetHeight > subMenuHeight){
            subMenuHeight = subMenu[i].offsetHeight;
        }
    }

    for(let j = 0; j< mainMenuList.length; j++){
        mainMenuList[j].addEventListener('mouseover', function(){
            header.style.height = headerHeight + subMenuHeight + 'px';
        });

        mainMenuList[j].addEventListener('mouseout', function(){
            header.style.height = headerHeight + 'px';
        });
    }
