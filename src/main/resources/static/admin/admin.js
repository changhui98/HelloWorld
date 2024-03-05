let header = document.querySelector('header'),
    nav = document.querySelector('nav');

     nav.addEventListener('mouseover', function(){
        header.style.height = '220px';
     });

     nav.addEventListener('mouseout', function(){
        header.style.height = '100px';
     });

/* 게시판 관리 */
const delete_elements = document.getElementsByClassName("delete");
    Array.from(delete_elements).forEach(function(element) {
        element.addEventListener('click', function(){
            if(confirm("정말로 삭제하시겠습니까?")){
            location.href= this.dataset.uri;
            };
        });
    });



const DEFAULT_HEIGHT = 40;

const $textarea = document.querySelector('textarea');
    $textarea.oninput = (event) => {
        const $target = event.target;

        $target.style.height = 0;
        $target.style.height = DEFAULT_HEIGHT + $target.scrollHeight + 'px';
    };