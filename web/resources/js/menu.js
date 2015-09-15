$(document).ready(main);

var contador = 1;

function main() {
	$('.Small-menu').click(function(){
		//$('.MainMenu').toggle();

		if(contador == 1) {
			$('.MainMenu').animate({
				left:'0'
			});
			contador = 0;
		} else {
			contador = 1;
			$('.MainMenu').animate({
				left:'-100%'
			});
		}
	})
}