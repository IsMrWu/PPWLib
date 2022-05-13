/**
 * //  AAChartModel.java
 * //  AAChartCore
 * //
 * //  Created by AnAn on 2017/9/8..
 * //  Copyright © 2018年 An An. All rights reserved.
 *
 * ◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉ ...... SOURCE CODE ......◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉
 * ◉◉◉...................................................       ◉◉◉
 * ◉◉◉   https://github.com/AAChartModel/AAChartCore            ◉◉◉
 * ◉◉◉   https://github.com/AAChartModel/AAChartCore-Kotlin     ◉◉◉
 * ◉◉◉...................................................       ◉◉◉
 * ◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉ ...... SOURCE CODE ......◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉
 *
 *
 * -------------------------------------------------------------------------------
 *
 * 🌕 🌖 🌗 🌘  ❀❀❀   WARM TIPS!!!   ❀❀❀ 🌑 🌒 🌓 🌔
 *
 * Please contact me on GitHub,if there are any problems encountered in use.
 * GitHub Issues : https://github.com/AAChartModel/AAChartCore/issues
 * -------------------------------------------------------------------------------
 * And if you want to contribute for this project, please contact me as well
 * GitHub        : https://github.com/AAChartModel
 * StackOverflow : https://stackoverflow.com/users/7842508/codeforu
 * JianShu       : http://www.jianshu.com/u/f1e6753d4254
 * SegmentFault  : https://segmentfault.com/u/huanghunbieguan
 *
 * -------------------------------------------------------------------------------
 */

package com.simuwang.aachart.chartcreator;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.simuwang.aachart.optionsmodel.AAOptions;
import com.simuwang.aachart.tools.AAJSStringPurer;
import com.simuwang.aachart.tools.JsonUtil;
import java.util.HashMap;
import java.util.Map;

public class AAChartView extends WebView {

  public interface AAChartViewCallBack {
    void chartViewDidFinishLoad(AAChartView aaChartView);

    void chartViewMoveOverEventMessage(
        AAChartView aaChartView,
        AAMoveOverEventMessageModel messageModel
    );
  }

  public Float contentWidth;
  public Float contentHeight;
  public Boolean chartSeriesHidden;
  public Boolean isClearBackgroundColor;
  public AAChartViewCallBack callBack;

  public void setContentWidth(Float contentWidth) {
    this.contentWidth = contentWidth;
    String jsStr = "setTheChartViewContentWidth('"
        + this.contentWidth + "')";
    safeEvaluateJavaScriptString(jsStr);
  }

  public void setContentHeight(Float contentHeight) {
    this.contentHeight = contentHeight;
    String jsStr = "setTheChartViewContentHeight('"
        + this.contentHeight + "')";
    safeEvaluateJavaScriptString(jsStr);
  }

  public void setChartSeriesHidden(Boolean chartSeriesHidden) {
    this.chartSeriesHidden = chartSeriesHidden;
    String jsStr = "setChartSeriesHidden('"
        + this.chartSeriesHidden + "')";
    safeEvaluateJavaScriptString(jsStr);
  }

  public void setIsClearBackgroundColor(Boolean isClearBackgroundColor) {
    this.isClearBackgroundColor = isClearBackgroundColor;
    if (this.isClearBackgroundColor) {
      this.setBackgroundColor(0);
      this.getBackground().setAlpha(0);
    } else {
      this.setBackgroundColor(1);
      this.getBackground().setAlpha(255);
    }
  }

  private String optionsJson;

  public AAChartView(
      Context context
  ) {
    super(context);
    setupBasicContent();
  }

  public AAChartView(
      Context context,
      AttributeSet attrs
  ) {
    super(context, attrs);
    setupBasicContent();
  }

  public AAChartView(
      Context context,
      AttributeSet attrs,
      int defStyleAttr
  ) {
    super(context, attrs, defStyleAttr);
    setupBasicContent();
  }

  @Override public boolean dispatchTouchEvent(MotionEvent ev) {
      /*if (ev.getAction() == MotionEvent.ACTION_UP) {
          simulateClick(this, 0, 0);
      }*/
    return super.dispatchTouchEvent(ev);
  }

  private void simulateClick(View view, float x, float y) {
    long downTime = SystemClock.uptimeMillis();
    final MotionEvent downEvent =
        MotionEvent.obtain(downTime, downTime, MotionEvent.ACTION_DOWN, x, y, 0);
    downTime += 1000;
    final MotionEvent upEvent =
        MotionEvent.obtain(downTime, downTime, MotionEvent.ACTION_UP, x, y, 0);
    view.onTouchEvent(downEvent);
    view.onTouchEvent(upEvent);
    downEvent.recycle();
    upEvent.recycle();
  }

  private void setupBasicContent() {
    // Do some initialize work.
    this.contentWidth = 420f;
    this.contentHeight = 580f;
    this.isClearBackgroundColor = false;
    this.getSettings().setJavaScriptEnabled(true);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      setWebContentsDebuggingEnabled(true);
    }
    //把当前对象作为androidObject别名传递给js
    //js通过window.androidObject.androidMethod()就可以直接调用安卓的androidMethod方法
    this.addJavascriptInterface(this, "androidObject");
  }

  //js调用安卓，必须加@JavascriptInterface注释的方法才可以被js调用
  @JavascriptInterface
  public String androidMethod(String message) {
    AAMoveOverEventMessageModel eventMessageModel =
        JsonUtil.parseObject(message, AAMoveOverEventMessageModel.class);
    if (callBack != null) {
      callBack.chartViewMoveOverEventMessage(this, eventMessageModel);
    }
    //       Log.i("androidMethod","++++++++++++++++显示总共调用了几次");
    return "";
  }

  public void aa_drawChartWithChartModel(final AAChartModel chartModel) {
    AAOptions aaOptions = chartModel.aa_toAAOptions();
    this.aa_drawChartWithChartOptions(aaOptions);
  }

  public void aa_refreshChartWithChartModel(AAChartModel chartModel) {
    AAOptions aaOptions = chartModel.aa_toAAOptions();
    this.aa_refreshChartWithChartOptions(aaOptions);
  }

  public void aa_drawChartWithChartOptions(final AAOptions chartOptions) {
    if (this.optionsJson != null) {
      this.aa_refreshChartWithChartOptions(chartOptions);
    } else {
      this.loadLocalFilesAndDrawChart(chartOptions);
      this.showJavaScriptAlertView();
    }
  }

  public void aa_refreshChartWithChartOptions(AAOptions chartOptions) {
    configureChartOptionsAndDrawChart(chartOptions);
  }

  public void aa_onlyRefreshTheChartDataWithChartOptionsSeriesArray(
      AASeriesElement[] seriesElementsArr
  ) {
    aa_onlyRefreshTheChartDataWithChartOptionsSeriesArray(seriesElementsArr, true);
  }

  public void aa_onlyRefreshTheChartDataWithChartOptionsSeriesArray(
      AASeriesElement[] seriesElementsArr,
      Boolean animation
  ) {
    String seriesArr = JsonUtil.toJSONString(seriesElementsArr);
    String javaScriptStr = "onlyRefreshTheChartDataWithSeries('"
        + seriesArr + "','" + animation + "')";
    this.safeEvaluateJavaScriptString(javaScriptStr);
  }

  public void aa_updateChartWithOptions(
      Object options,
      Boolean redraw
  ) {
    String classNameStr = options.getClass().getSimpleName();
    classNameStr = classNameStr.replace("AA", "");

    //convert fist character to be lowercase string
    String firstChar = classNameStr.substring(0, 1);
    String lowercaseFirstStr = firstChar.toLowerCase();
    classNameStr = classNameStr.substring(1);
    String finalClassName = lowercaseFirstStr + classNameStr;

    Map finalOptionsMap = new HashMap();
    finalOptionsMap.put(finalClassName, options);

    String optionsStr = JsonUtil.toJSONString(finalOptionsMap);
    String javaScriptStr = "updateChart('" + optionsStr + "','" + redraw + "')";
    this.safeEvaluateJavaScriptString(javaScriptStr);
  }

  public void aa_addPointToChartSeriesElement(
      Integer elementIndex,
      Object options
  ) {
    aa_addPointToChartSeriesElement(
        elementIndex,
        options,
        true);
  }

  public void aa_addPointToChartSeriesElement(
      Integer elementIndex,
      Object options,
      Boolean shift
  ) {
    aa_addPointToChartSeriesElement(
        elementIndex,
        options,
        true,
        shift,
        true);
  }

  public void aa_addPointToChartSeriesElement(
      Integer elementIndex,
      Object options,
      Boolean redraw,
      Boolean shift,
      Boolean animation
  ) {
    String optionsStr;
    if (options instanceof Integer
        || options instanceof Float
        || options instanceof Double) {
      optionsStr = String.valueOf(options);
    } else {
      optionsStr = JsonUtil.toJSONString(options);
    }

    String javaScriptStr = "addPointToChartSeries('"
        + elementIndex + "','"
        + optionsStr + "','"
        + redraw + "','"
        + shift + "','"
        + animation + "')";
    this.safeEvaluateJavaScriptString(javaScriptStr);
  }

  public void aa_showTheSeriesElementContent(Integer elementIndex) {
    String javaScriptStr = "showTheSeriesElementContentWithIndex('"
        + elementIndex + "')";
    this.safeEvaluateJavaScriptString(javaScriptStr);
  }

  public void aa_hideTheSeriesElementContent(Integer elementIndex) {
    String javaScriptStr = "hideTheSeriesElementContentWithIndex('"
        + elementIndex + "')";
    this.safeEvaluateJavaScriptString(javaScriptStr);
  }

  public void aa_addElementToChartSeries(AASeriesElement aaSeriesElement) {
    String pureElementJsonStr = JsonUtil.toJSONString(aaSeriesElement);
    String javaScriptStr = "addElementToChartSeriesWithElement('"
        + pureElementJsonStr + "')";
    this.safeEvaluateJavaScriptString(javaScriptStr);
  }

  public void aa_removeElementFromChartSeries(Integer elementIndex) {
    String javaScriptStr = "removeElementFromChartSeriesWithElementIndex('"
        + elementIndex + "')";
    this.safeEvaluateJavaScriptString(javaScriptStr);
  }

  public void aa_evaluateTheJavaScriptStringFunction(String jsFunctionStr) {
    String pureJSFunctionStr = AAJSStringPurer.pureJavaScriptFunctionString(jsFunctionStr);

    String jsFunctionNameStr = "evaluateTheJavaScriptStringFunction('"
        + pureJSFunctionStr + "')";
    safeEvaluateJavaScriptString(jsFunctionNameStr);
  }

  private void loadLocalFilesAndDrawChart(final AAOptions aaOptions) {
    this.loadUrl("file:///android_asset/AAChartView.html");
    this.setWebViewClient(new WebViewClient() {
      @Override
      public void onPageFinished(WebView view, String url) {
        //                Log.i("js files load","图表加载完成!!!!!!!! ");
        configureChartOptionsAndDrawChart(aaOptions);

        if (callBack != null) {
          callBack.chartViewDidFinishLoad(AAChartView.this);
        }
      }
    });
  }

  private void configureChartOptionsAndDrawChart(AAOptions chartOptions) {
    if (isClearBackgroundColor) {
      chartOptions.chart.backgroundColor("rgba(0,0,0,0)");
    }

    String aaOptionsJsonStr = JsonUtil.toJSONString(chartOptions);
    this.optionsJson = aaOptionsJsonStr;
    String javaScriptStr = "loadTheHighChartView('"
        + aaOptionsJsonStr + "','"
        + this.contentWidth + "','"
        + this.contentHeight + "')";
    this.safeEvaluateJavaScriptString(javaScriptStr);
  }

  private void showJavaScriptAlertView() {
    this.setWebChromeClient(new WebChromeClient() {
      @Override
      public boolean onJsAlert(WebView view,
          String url,
          String message,
          final JsResult result) {
        super.onJsAlert(view, url, message, result);

        String urlStr = "url --->" + url + "\n\n\n";
        String messageStr = "message --->" + message + "\n\n\n";
        String resultStr = "result --->" + result;

        String alertMessageStr = urlStr + messageStr + resultStr;

        new AlertDialog.Builder(getContext())
            .setTitle("JavaScript alert Information")//设置对话框标题
            .setMessage(alertMessageStr)
            .setNeutralButton("sure", null)
            .show();

        return true;
      }
    });
  }

  private void safeEvaluateJavaScriptString(String javaScriptString) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      this.evaluateJavascript("javascript:" + javaScriptString, new ValueCallback<String>() {
        @Override
        public void onReceiveValue(String s) {
          //                    Log.i("call back information","输出打印查看回调的结果"+s);
        }
      });
    } else {
      this.loadUrl("javascript:" + javaScriptString);
    }
  }
}
