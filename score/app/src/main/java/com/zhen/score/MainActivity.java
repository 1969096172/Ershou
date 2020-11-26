//package com.zhen.score;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//import java.text.DecimalFormat;
//
//public class MainActivity extends AppCompatActivity {//Activity有自动运行函数“oncreate”是函数入口
//    private  StringBuilder show_equation=new StringBuilder(); //显示运算符
//    String inputstr = new String();
//    Button[] number_bt=new Button[14];//用来接收从界面获取的数字按钮
//    Button[] oprt_bt=new Button[5];//用来接收从界面获取的运算符按钮
//    Button deletebt;
//    TextView result_et;
//    Button clear_bt;//用来接收从界面获取的clear按钮
//    boolean firstFlag=true;
//    boolean clearFlag=false;
//    double result=0.0;
//    String lastOprt=" ";//上一个操作符
//    String numb1="";
//    String numb2="";
//    String lastCommand = " ";
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {//自动运行的函数
//        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_calu);
////        setContentView(R.layout.activity_main);
//        setContentView(R.layout.constrained);
//        show_equation = new StringBuilder();
//        initView();
//        setEvent();
//    }
//    void initView(){
//        number_bt[0]=findViewById(R.id.num0);
//        number_bt[1]=findViewById(R.id.num1);
//        number_bt[2]=findViewById(R.id.num2);
//        number_bt[3]=findViewById(R.id.num3);
//        number_bt[4]=findViewById(R.id.num4);
//        number_bt[5]=findViewById(R.id.num5);
//        number_bt[6]=findViewById(R.id.num6);
//        number_bt[7]=findViewById(R.id.num7);
//        number_bt[8]=findViewById(R.id.num8);
//        number_bt[9]=findViewById(R.id.num9);
//        number_bt[10]=findViewById(R.id.dot);
//        deletebt=findViewById(R.id.delete);
//        oprt_bt[0]=findViewById(R.id.plus);
//        oprt_bt[1]=findViewById(R.id.minus);
//        oprt_bt[2]=findViewById(R.id.multiply);
//        oprt_bt[3]=findViewById(R.id.divid);
//        oprt_bt[4]=findViewById(R.id.equal);
//        result_et=findViewById(R.id.result_id);
//        clear_bt=findViewById(R.id.clearbt);
//        result_et.setText("");
//    }
//    void setEvent(){
//        NumberClickListener numberClickLiatener=new NumberClickListener();//实例化对象
////        for (int i=0;i<number_bt.length;i++){//循环
////            number_bt[i].setOnClickListener(numberClickLiatener);
////        }
//        for (Button tempbt:number_bt){//遍历对象
//            tempbt.setOnClickListener(numberClickLiatener);
//        }
//        OperatorClickListener operatorClickListener=new OperatorClickListener();
//        for (Button tempbt:oprt_bt){//遍历对象
//            tempbt.setOnClickListener(operatorClickListener);
//        }
//        clear_bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                firstFlag=true;
//                result_et.setText("");
//                clearFlag=false;
//                result=0.0;
//                numb1="";
//                numb2="";
//                lastCommand = " ";
//            }
//        });
//        deletebt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String resultstr=result_et.getText().toString();
//                if(resultstr.equals("")){
//                    return;
//                }
//                String laststr = resultstr.substring(resultstr.length()-2);
////                String rightstr = resultstr.substring(0,resultstr.length()-2);
////                for(Button tempbt:oprt_bt){
////                    if(laststr.equals(tempbt)){
////                        lastCommand = "";
////
////                        break;
////                    }
////                }
//            if(!lastCommand.equals("")&&numb2.equals("")){
//                lastCommand="";
//                result_et.setText(numb1);
//                return;
//            }
//                if(lastCommand.equals("")){
//                    numb1=numb1.substring(0,numb1.length()-1);
//                    result_et.setText(numb1);
//                }
//                if(!lastCommand.equals("")){
//                    numb2 = numb2.substring(0,numb2.length()-1);
//                    result_et.setText(numb1+lastCommand+numb2);
//                }
//
//            }
//        });
//    }
//    static class NumberClickListener implements View.OnClickListener{
//
//        @Override
//        public void onClick(View v) {
//            Button inputbt=(Button)v;//表示获得了某个按钮
//            String inputstr=inputbt.getText().toString();//表示获取按钮上的内容
//            String resultstr = result_et.getText().toString();//获取输入的内容
//            if(firstFlag){
//                if(inputstr.equals(".")){
//                    return;//获取第一次按钮内容为小数点时，不响应
//                }
//                numb1 = numb1+inputstr;
//                result_et.setText("");
//                result_et.setText(numb1);
//                firstFlag=false;//排除第一次输入为小数点的情况之后，如果第一次按键要响应，就必须把firstFlag设为false
//            }else{
//                if(lastCommand.equals("")){
//                    if (numb1.indexOf(".")>0&&inputstr.equals(".")){//如果当前输入已经包含.并且现在输入.则不响应
//                        return;
//                    }
//                    if (numb1.equals("0")&&!inputstr.equals(".")){//如果当前输入已经包含0并且现在输入不是.则不响应
//                        return;
//                    }
//                    if (numb1.equals("-")&&!inputstr.equals(".")){//如果当前输入已经包含-并且现在输入不是.则不响应
//                        return;
//                    }
//                    if (numb1.equals("-0")&&!inputstr.equals(".")){//如果当前输入已经包含-并且现在输入不是.则不响应
//                        return;
//                    }
//                    numb1 = numb1+inputstr;
//                    result_et.setText(numb1);
//                }
//                if (!lastCommand.equals("")){
//                    if (numb2.contains(".")&&inputstr.equals(".")){//如果当前输入已经包含.并且现在输入.则不响应
//                        return;
//                    }
//                    if (numb2.equals("0")&&!inputstr.equals(".")){//如果当前输入已经包含0并且现在输入不是.则不响应
//                        return;
//                    }
//                    if (numb2.equals("-")&&!inputstr.equals(".")){//如果当前输入已经包含-并且现在输入不是.则不响应
//                        return;
//                    }
//                    if (numb2.equals("-0")&&!inputstr.equals(".")){//如果当前输入已经包含-并且现在输入不是.则不响应
//                        return;
//                    }
//                    numb2 = numb2+inputstr;
//                    result_et.setText(numb1+lastCommand+numb2);
//                }
//            }
////            result_et.setText(result_et.getText().toString()+inputstr);//怎么设置这个值达到清除的效果
////            result_et.setText(show_equation);
//        }
//    }
//    static class OperatorClickListener implements View.OnClickListener{
//
//        @Override
//        public void onClick(View v) {
//            Button inputbt=(Button)v;
//            String inputstr=inputbt.getText().toString();
//            String resultstr=result_et.getText().toString();
//            if (firstFlag){
//                if (inputstr.equals("-")){
//                    numb1=numb1+inputstr;
//                    result_et.setText(numb1);
//                    firstFlag=false;
//                }
//            }else {
//
//                if(numb1.equals("-")){
//                    return;
//
//                }
//                if (numb2.equals("")){
//                   lastCommand=inputstr;
//                   result_et.setText(numb1+lastCommand);
//                }
//                if(!numb1.equals("")&&!numb2.equals("")){
//                    calc(Double.parseDouble(numb1),Double.parseDouble(numb2));
//                    result_et.setText(numb1+lastCommand+numb2+"="+result);
//                    lastCommand="";
//                }
//            }
//        }
//
//
//        private void calc(double bumb1,double bumb2) {
//            if (lastCommand.equals("+")){
//                result=bumb1+bumb2;
//            }
//            if (lastCommand.equals("-")){
//                result=bumb1-bumb2;
//            }
//            if (lastCommand.equals("*")){
//                result=bumb1*bumb2;
//            }
//            if (lastCommand.equals("/")){
//                result=bumb1/bumb2;
//            }
//
//            DecimalFormat df=new DecimalFormat("#.00");
//            result=Double.parseDouble(df.format(result));
//        }
//    }
//}