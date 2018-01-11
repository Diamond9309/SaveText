package savetxt.hxzdsb.bh.savetxt;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_text;
    private ListView lv_txt;
    private Button btn_save, btn_cancel;
    private TextView tv_text;
    private String s;
    String filePath = "/sdcard/Test/";
    //    String fileName = DateFormat.format("yyyyMMdd", Calendar.getInstance(Locale.CHINA)) + ".txt";
    String fileName = DateFormat.format("yyyyMMdd", Calendar.getInstance(Locale.CHINA)) + ".txt";
    private String str;
    private MainActivity activity;
    private ArrayList <txtbean>list = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_text = (TextView) findViewById(R.id.tv_read);

        initView();
        getData();
        showInfo();
//        readTask readTask = new readTask();
//        readTask.execute();
    }


    //控件的获取
    private void initView() {
//        lv_txt = (ListView) findViewById(R.id.lv_read);
        et_text = (EditText) findViewById(R.id.et_text);
        btn_save = (Button) findViewById(R.id.bth_save);
        btn_cancel = (Button) findViewById(R.id.btn_cancel);
        btn_save.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);


        et_text.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {

                        if (!tv_text.getText().toString().contains(et_text.getText().toString())) {
                            writeTxtToFile(et_text.getText().toString(), filePath, fileName);
                           Toast.makeText(MainActivity.this, "数据保存成功", Toast.LENGTH_SHORT).show();
                            tv_text.setText(et_text.getText().toString()+"\n"+tv_text.getText().toString());
                        }else {
                            Toast.makeText(MainActivity.this, "条码信息已经保存", Toast.LENGTH_SHORT).show();
                        }

                }
                return false;
            }
        });
    }

    //获取在editView里面扫描到的数据
    private void getData() {
//        et_text.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if (actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
//
////                        if (!tv_text.getText().toString().contains(et_text.getText().toString())) {
//
//
//                    listadapter listadapter = new listadapter(MainActivity.this,list);
//
//                    Toast.makeText(MainActivity.this, "@@@@@2", Toast.LENGTH_SHORT).show();
//                    for (int i = 0; i < list.size(); i++) {
//                        txtbean txtbean = new txtbean();
////                        if (!et_text.getText().equals(list.get(i))) {
////                            writeTxtToFile(et_text.getText().toString(), filePath, fileName);
////                            Toast.makeText(MainActivity.this, "数据保存成功", Toast.LENGTH_SHORT).show();
//                            txtbean.setBarcode(et_text.getText().toString());
//                            list.add(txtbean);
//                            listadapter.notifyDataSetChanged();
////                        }else {
////                            Toast.makeText(activity, "条码以保存", Toast.LENGTH_SHORT).show();
////                        }
//                    }
//
//                    lv_txt.setAdapter(listadapter);
//
////                            String str = tv_text.getText() + "\n" + et_text.getText();
////                            tv_text.setText("");
////                            tv_text.setText(str);
////                            tv_text.invalidate();
//
////                        String str=tv_text.getText()+"\n"+et_text.getText();
////                        tv_text.setText("");
////                        tv_text.setText(str);
//
//
//                }
////                    }
//                return false;
//            }
//        });

    }

    public static String StringFilter(String str) throws PatternSyntaxException {
        String regEx = "[@]"; // 要过滤掉的字符
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.bth_save:
//                if (tv_text.getText().toString().contains(et_text.getText().toString())){
//
//                    Toast.makeText(this, "该条码以保存过，请仔细检查", Toast.LENGTH_SHORT).show();
//                }else {
//
//                    writeTxtToFile(et_text.getText().toString(), filePath, fileName);
//                    Toast.makeText(this, "数据以保存", Toast.LENGTH_SHORT).show();
//                    showInfo();
//                }
                break;


            case R.id.btn_cancel:
                et_text.setText("");
                break;
        }
    }


    // 将字符串写入到文本文件中
    public void writeTxtToFile(String strcontent, String filePath, String fileName) {
        //生成文件夹之后，再生成文件，不然会出错
        makeFilePath(filePath, fileName);

        String strFilePath = filePath + fileName;
        // 每次写入时，都换行写
        String strContent = strcontent + "\r\n";
        try {
            File file = new File(strFilePath);
            if (!file.exists()) {
                Log.d("TestFile", "Create the file:" + strFilePath);
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            RandomAccessFile raf = new RandomAccessFile(file, "rwd");
            raf.seek(file.length());
            raf.write(strContent.getBytes());
            raf.close();
        } catch (Exception e) {
            Log.e("TestFile", "Error on write File:" + e);
        }
    }

    // 生成文件
    public File makeFilePath(String filePath, String fileName) {
        File file = null;
        makeRootDirectory(filePath);
        try {
            file = new File(filePath + fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }


    // 生成文件夹
    public static void makeRootDirectory(String filePath) {
        File file = null;
        try {
            file = new File(filePath);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {
            Log.i("error:", e + "");
        }

    }

    //读取文件
    private void showInfo() {

        File file = new File(filePath + fileName);
        str = null;
        try {
            InputStream is = new FileInputStream(file);
            InputStreamReader input = new InputStreamReader(is, "UTF-8");
            BufferedReader reader = new BufferedReader(input);
            while ((str = reader.readLine()) != null) {
                tv_text.append(str);
                tv_text.append("\n");
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    class readTask extends AsyncTask {
        @Override
        protected void onPostExecute(Object o) {


        }

        @Override
        protected Object doInBackground(Object[] params) {


            return null;
        }
    }

}
