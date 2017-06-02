/***********************下是验证码对象*****************/
var Validation = {};
Validation.init = function(eleName,imageSrc){
    this.image = imageSrc;
    $('#'+eleName).focusin(function(){
        Validation.show(eleName);
    });
}

Validation.image = '';
Validation.display=false;
Validation.width = '100px';
Validation.height = '30px';
Validation.div = null;
Validation.show = function(eleName){
    if(this.display==false){
        //首次显示
        if(this.div==null){
            $('#'+eleName).after('<div style="display:none;" id="div_validation_'+eleName+'" title="点击更换"></div>');
            this.div = $('#div_validation_'+eleName);
            this.div.css('position','absolute');
            this.div.css('cursor','pointer');
            this.div.css('border','1px solid #CCC');
            this.div.css('background-color','#FFF');
            this.div.css('background-position','center');
            this.div.css('background-repeat','no-repeat');
            this.div.css('height',this.height);
            this.div.css('width',this.width);
            var objOffset = $('#'+eleName).offset();
            objOffset.top+=$('#'+eleName).height()+6;
            this.div.offset(objOffset);
            this.div.css('background-image','url('+Validation.image+'&_t='+new Date()+')');
            this.div.css('display','inline-block');
            this.display = true;
            //点击更换
            this.div.click(function(){
                Validation.div.css('background-image','url('+Validation.image+'&_t='+new Date()+')');
            });
        }
        else{
            this.div.css('background-image','url('+Validation.image+'&_t='+new Date()+')');
            this.display = true;
            this.div.css('display','inline-block');
        }
    }
}
Validation.hide =function(){
    if(this.display==true){
        this.display = false;
        this.div.hide();
    }
}