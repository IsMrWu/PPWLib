/**
 * //  AASeriesElement.java
 * //  AAChartCore
 * //
 * //  Created by anan on 2018/4/16..
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

import com.simuwang.aachart.optionsmodel.AADataLabels;
import com.simuwang.aachart.optionsmodel.AAMarker;
import com.simuwang.aachart.optionsmodel.AAShadow;
import com.simuwang.aachart.optionsmodel.AATooltip;

/**
 * Created by anan on 2018/4/16.
 */
public class AASeriesElement {

  public String type;
  public Boolean allowPointSelect;
  public String name;
  public Object[] data;
  public Float lineWidth;//折线图、曲线图、直方折线图、折线填充图、曲线填充图、直方折线填充图的线条宽度
  public Float borderWidth;
  public Object color;
  public Object fillColor;
  public Float fillOpacity;//折线填充图、曲线填充图、直方折线填充图等填充图类型的填充颜色透明度
  public Float threshold;
  //The threshold, also called zero level or base level. For line type series this is only used in conjunction with negativeColor. default：0.
  public String negativeColor;
  // The color for the parts of the graph or points that are below the threshold
  public Object negativeFillColor;
  public Object size;
  public Object innerSize;
  public String dashStyle;
  public Integer yAxis;
  public AADataLabels dataLabels;
  public AAMarker marker;
  public Object step;
  public Object states;
  public Boolean colorByPoint;
  public Integer zIndex;
  public Object[] zones;
  public AAShadow shadow;
  public String stack;
  public AATooltip tooltip;
  public Boolean showInLegend;
  public Boolean enableMouseTracking;
  public Boolean reversed;

  public AASeriesElement type(String prop) {
    type = prop;
    return this;
  }

  public AASeriesElement allowPointSelect(Boolean prop) {
    allowPointSelect = prop;
    return this;
  }

  public AASeriesElement name(String prop) {
    name = prop;
    return this;
  }

  public AASeriesElement data(Object[] prop) {
    data = prop;
    return this;
  }

  public AASeriesElement lineWidth(Float prop) {
    lineWidth = prop;
    return this;
  }

  public AASeriesElement borderWidth(Float prop) {
    borderWidth = prop;
    return this;
  }

  public AASeriesElement color(Object prop) {
    color = prop;
    return this;
  }

  public AASeriesElement fillColor(Object prop) {
    fillColor = prop;
    return this;
  }

  public AASeriesElement fillOpacity(Float prop) {
    fillOpacity = prop;
    return this;
  }

  public AASeriesElement threshold(Float prop) {
    threshold = prop;
    return this;
  }

  public AASeriesElement negativeColor(String prop) {
    negativeColor = prop;
    return this;
  }

  public AASeriesElement negativeFillColor(Object prop) {
    negativeFillColor = prop;
    return this;
  }

  public AASeriesElement size(Object prop) {
    size = prop;
    return this;
  }

  public AASeriesElement innerSize(Object prop) {
    innerSize = prop;
    return this;
  }

  public AASeriesElement dashStyle(String prop) {
    dashStyle = prop;
    return this;
  }

  public AASeriesElement yAxis(Integer prop) {
    yAxis = prop;
    return this;
  }

  public AASeriesElement dataLabels(AADataLabels prop) {
    dataLabels = prop;
    return this;
  }

  public AASeriesElement marker(AAMarker prop) {
    marker = prop;
    return this;
  }

  public AASeriesElement step(Object prop) {
    step = prop;
    return this;
  }

  public AASeriesElement states(Object prop) {
    states = prop;
    return this;
  }

  public AASeriesElement colorByPoint(Boolean prop) {
    colorByPoint = prop;
    return this;
  }

  public AASeriesElement zIndex(Integer prop) {
    zIndex = prop;
    return this;
  }

  public AASeriesElement zones(Object[] prop) {
    zones = prop;
    return this;
  }

  public AASeriesElement shadow(AAShadow prop) {
    shadow = prop;
    return this;
  }

  public AASeriesElement stack(String prop) {
    stack = prop;
    return this;
  }

  public AASeriesElement tooltip(AATooltip prop) {
    tooltip = prop;
    return this;
  }

  public AASeriesElement showInLegend(Boolean prop) {
    showInLegend = prop;
    return this;
  }

  public AASeriesElement enableMouseTracking(Boolean prop) {
    enableMouseTracking = prop;
    return this;
  }

  public AASeriesElement reversed(Boolean prop) {
    reversed = prop;
    return this;
  }
}





