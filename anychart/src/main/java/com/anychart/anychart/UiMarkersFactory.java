package com.anychart.anychart;

import java.util.Locale;

// class
/**
 * Multiple markers class.<br/>
Multiple markers are the set of markers with a common settings, such as type (predefined or
custom), size, fill and position:
<ul>
  <li>{@link anychart.core.ui.MarkersFactory#anchor}</li>
  <li>{@link anychart.core.ui.MarkersFactory#position}</li>
  <li>{@link anychart.core.ui.MarkersFactory#offsetX} and {@link anychart.core.ui.MarkersFactory#offsetY}</li>
</ul>
Also you can access any marker from the set and change it.
 */
public class UiMarkersFactory extends VisualBase {

    public UiMarkersFactory() {
        js.setLength(0);
        js.append("var uiMarkersFactory").append(++variableIndex).append(" = anychart.core.ui.markersFactory();");
        jsBase = "uiMarkersFactory" + variableIndex;
    }

    protected UiMarkersFactory(String jsBase) {
        js.setLength(0);
        this.jsBase = jsBase;
    }

    protected UiMarkersFactory(StringBuilder js, String jsBase, boolean isChain) {
        this.js = js;
        this.jsBase = jsBase;
        this.isChain = isChain;
    }

    protected String getJsBase() {
        return jsBase;
    }

    
    private EnumsAnchor anchor;
    private String anchor1;

    /**
     * Setter for anchor settings of all markers.
     */
    public UiMarkersFactory setAnchor(EnumsAnchor anchor) {
        if (jsBase == null) {
            this.anchor = null;
            this.anchor1 = null;
            
            this.anchor = anchor;
        } else {
            this.anchor = anchor;
            if (!isChain) {
                js.append(jsBase);
                isChain = true;
            }
            
            js.append(String.format(Locale.US, ".anchor(%s)", ((anchor != null) ? anchor.generateJs() : "null")));

            if (isRendered) {
                onChangeListener.onChange(String.format(Locale.US, ".anchor(%s)", ((anchor != null) ? anchor.generateJs() : "null")));
                js.setLength(0);
            }
        }
        return this;
    }


    /**
     * Setter for anchor settings of all markers.
     */
    public UiMarkersFactory setAnchor(String anchor1) {
        if (jsBase == null) {
            this.anchor = null;
            this.anchor1 = null;
            
            this.anchor1 = anchor1;
        } else {
            this.anchor1 = anchor1;
            if (!isChain) {
                js.append(jsBase);
                isChain = true;
            }
            
            js.append(String.format(Locale.US, ".anchor(%s)", wrapQuotes(anchor1)));

            if (isRendered) {
                onChangeListener.onChange(String.format(Locale.US, ".anchor(%s)", wrapQuotes(anchor1)));
                js.setLength(0);
            }
        }
        return this;
    }

    private Fill fill;
    private String fill1;

    /**
     * Setter for fill settings of all markers.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public UiMarkersFactory setFill(Fill fill) {
        if (jsBase == null) {
            this.fill = null;
            this.fill1 = null;
            
            this.fill = fill;
        } else {
            this.fill = fill;
            if (!isChain) {
                js.append(jsBase);
                isChain = true;
            }
            
            js.append(String.format(Locale.US, ".fill(%s)", ((fill != null) ? fill.generateJs() : "null")));

            if (isRendered) {
                onChangeListener.onChange(String.format(Locale.US, ".fill(%s)", ((fill != null) ? fill.generateJs() : "null")));
                js.setLength(0);
            }
        }
        return this;
    }


    /**
     * Setter for fill settings of all markers.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public UiMarkersFactory setFill(String fill1) {
        if (jsBase == null) {
            this.fill = null;
            this.fill1 = null;
            
            this.fill1 = fill1;
        } else {
            this.fill1 = fill1;
            if (!isChain) {
                js.append(jsBase);
                isChain = true;
            }
            
            js.append(String.format(Locale.US, ".fill(%s)", wrapQuotes(fill1)));

            if (isRendered) {
                onChangeListener.onChange(String.format(Locale.US, ".fill(%s)", wrapQuotes(fill1)));
                js.setLength(0);
            }
        }
        return this;
    }

    private String color;
    private Double opacity;

    /**
     * Fill color with opacity. Fill as a string or an object.
     */
    public UiMarkersFactory fill(String color, Double opacity) {
        if (jsBase == null) {
            this.color = color;
            this.opacity = opacity;
        } else {
            this.color = color;
            this.opacity = opacity;
            if (!isChain) {
                js.append(jsBase);
                isChain = true;
            }
            
            js.append(String.format(Locale.US, ".fill(%s, %f)", wrapQuotes(color), opacity));

            if (isRendered) {
                onChangeListener.onChange(String.format(Locale.US, ".fill(%s, %f)", wrapQuotes(color), opacity));
                js.setLength(0);
            }
        }
        return this;
    }

    private GradientKey[] keys;
    private String[] keys1;
    private Double angle;
    private Boolean mode;
    private VectorRect mode1;
    private String mode2;
    private Double opacity1;

    /**
     * Linear gradient fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public UiMarkersFactory fill(GradientKey[] keys, Double angle, Double opacity1, Boolean mode) {
        if (jsBase == null) {
            this.keys = null;
            this.keys1 = null;
            
            this.keys = keys;
            this.angle = angle;
            this.opacity = null;
            this.opacity1 = null;
            
            this.opacity1 = opacity1;
            this.mode = null;
            this.mode1 = null;
            this.mode2 = null;
            
            this.mode = mode;
        } else {
            this.keys = keys;
            this.angle = angle;
            this.opacity1 = opacity1;
            this.mode = mode;
            if (!isChain) {
                js.append(jsBase);
                isChain = true;
            }
            
            js.append(String.format(Locale.US, ".fill(%s, %f, %f, %b)", arrayToString(keys), angle, opacity1, mode));

            if (isRendered) {
                onChangeListener.onChange(String.format(Locale.US, ".fill(%s, %f, %f, %b)", arrayToString(keys), angle, opacity1, mode));
                js.setLength(0);
            }
        }
        return this;
    }


    /**
     * Linear gradient fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public UiMarkersFactory fill(GradientKey[] keys, Double angle, Double opacity1, VectorRect mode1) {
        if (jsBase == null) {
            this.keys = null;
            this.keys1 = null;
            
            this.keys = keys;
            this.angle = angle;
            this.opacity = null;
            this.opacity1 = null;
            
            this.opacity1 = opacity1;
            this.mode = null;
            this.mode1 = null;
            this.mode2 = null;
            
            this.mode1 = mode1;
        } else {
            this.keys = keys;
            this.angle = angle;
            this.opacity1 = opacity1;
            this.mode1 = mode1;
            if (!isChain) {
                js.append(jsBase);
                isChain = true;
            }
            js.append(mode1.generateJs());
            js.append(String.format(Locale.US, ".fill(%s, %f, %f, %s)", arrayToString(keys), angle, opacity1, ((mode1 != null) ? mode1.getJsBase() : "null")));

            if (isRendered) {
                onChangeListener.onChange(String.format(Locale.US, ".fill(%s, %f, %f, %s)", arrayToString(keys), angle, opacity1, ((mode1 != null) ? mode1.getJsBase() : "null")));
                js.setLength(0);
            }
        }
        return this;
    }


    /**
     * Linear gradient fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public UiMarkersFactory fill(GradientKey[] keys, Double angle, Double opacity1, String mode2) {
        if (jsBase == null) {
            this.keys = null;
            this.keys1 = null;
            
            this.keys = keys;
            this.angle = angle;
            this.opacity = null;
            this.opacity1 = null;
            
            this.opacity1 = opacity1;
            this.mode = null;
            this.mode1 = null;
            this.mode2 = null;
            
            this.mode2 = mode2;
        } else {
            this.keys = keys;
            this.angle = angle;
            this.opacity1 = opacity1;
            this.mode2 = mode2;
            if (!isChain) {
                js.append(jsBase);
                isChain = true;
            }
            
            js.append(String.format(Locale.US, ".fill(%s, %f, %f, %s)", arrayToString(keys), angle, opacity1, wrapQuotes(mode2)));

            if (isRendered) {
                onChangeListener.onChange(String.format(Locale.US, ".fill(%s, %f, %f, %s)", arrayToString(keys), angle, opacity1, wrapQuotes(mode2)));
                js.setLength(0);
            }
        }
        return this;
    }


    /**
     * Linear gradient fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public UiMarkersFactory fill(String[] keys1, Double angle, Double opacity1, Boolean mode) {
        if (jsBase == null) {
            this.keys = null;
            this.keys1 = null;
            
            this.keys1 = keys1;
            this.angle = angle;
            this.opacity = null;
            this.opacity1 = null;
            
            this.opacity1 = opacity1;
            this.mode = null;
            this.mode1 = null;
            this.mode2 = null;
            
            this.mode = mode;
        } else {
            this.keys1 = keys1;
            this.angle = angle;
            this.opacity1 = opacity1;
            this.mode = mode;
            if (!isChain) {
                js.append(jsBase);
                isChain = true;
            }
            
            js.append(String.format(Locale.US, ".fill(%s, %f, %f, %b)", arrayToStringWrapQuotes(keys1), angle, opacity1, mode));

            if (isRendered) {
                onChangeListener.onChange(String.format(Locale.US, ".fill(%s, %f, %f, %b)", arrayToStringWrapQuotes(keys1), angle, opacity1, mode));
                js.setLength(0);
            }
        }
        return this;
    }


    /**
     * Linear gradient fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public UiMarkersFactory fill(String[] keys1, Double angle, Double opacity1, VectorRect mode1) {
        if (jsBase == null) {
            this.keys = null;
            this.keys1 = null;
            
            this.keys1 = keys1;
            this.angle = angle;
            this.opacity = null;
            this.opacity1 = null;
            
            this.opacity1 = opacity1;
            this.mode = null;
            this.mode1 = null;
            this.mode2 = null;
            
            this.mode1 = mode1;
        } else {
            this.keys1 = keys1;
            this.angle = angle;
            this.opacity1 = opacity1;
            this.mode1 = mode1;
            if (!isChain) {
                js.append(jsBase);
                isChain = true;
            }
            js.append(mode1.generateJs());
            js.append(String.format(Locale.US, ".fill(%s, %f, %f, %s)", arrayToStringWrapQuotes(keys1), angle, opacity1, ((mode1 != null) ? mode1.getJsBase() : "null")));

            if (isRendered) {
                onChangeListener.onChange(String.format(Locale.US, ".fill(%s, %f, %f, %s)", arrayToStringWrapQuotes(keys1), angle, opacity1, ((mode1 != null) ? mode1.getJsBase() : "null")));
                js.setLength(0);
            }
        }
        return this;
    }


    /**
     * Linear gradient fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public UiMarkersFactory fill(String[] keys1, Double angle, Double opacity1, String mode2) {
        if (jsBase == null) {
            this.keys = null;
            this.keys1 = null;
            
            this.keys1 = keys1;
            this.angle = angle;
            this.opacity = null;
            this.opacity1 = null;
            
            this.opacity1 = opacity1;
            this.mode = null;
            this.mode1 = null;
            this.mode2 = null;
            
            this.mode2 = mode2;
        } else {
            this.keys1 = keys1;
            this.angle = angle;
            this.opacity1 = opacity1;
            this.mode2 = mode2;
            if (!isChain) {
                js.append(jsBase);
                isChain = true;
            }
            
            js.append(String.format(Locale.US, ".fill(%s, %f, %f, %s)", arrayToStringWrapQuotes(keys1), angle, opacity1, wrapQuotes(mode2)));

            if (isRendered) {
                onChangeListener.onChange(String.format(Locale.US, ".fill(%s, %f, %f, %s)", arrayToStringWrapQuotes(keys1), angle, opacity1, wrapQuotes(mode2)));
                js.setLength(0);
            }
        }
        return this;
    }

    private GradientKey[] keys2;
    private String[] keys3;
    private Double cx;
    private Double cy;
    private GraphicsMathRect mode3;
    private Double opacity2;
    private Double fx;
    private Double fy;

    /**
     * Radial gradient fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public UiMarkersFactory fill(GradientKey[] keys2, Double cx, Double cy, GraphicsMathRect mode3, Double opacity2, Double fx, Double fy) {
        if (jsBase == null) {
            this.keys = null;
            this.keys1 = null;
            this.keys2 = null;
            this.keys3 = null;
            
            this.keys2 = keys2;
            this.cx = cx;
            this.cy = cy;
            this.mode = null;
            this.mode1 = null;
            this.mode2 = null;
            this.mode3 = null;
            
            this.mode3 = mode3;
            this.opacity = null;
            this.opacity1 = null;
            this.opacity2 = null;
            
            this.opacity2 = opacity2;
            this.fx = fx;
            this.fy = fy;
        } else {
            this.keys2 = keys2;
            this.cx = cx;
            this.cy = cy;
            this.mode3 = mode3;
            this.opacity2 = opacity2;
            this.fx = fx;
            this.fy = fy;
            if (!isChain) {
                js.append(jsBase);
                isChain = true;
            }
            js.append(mode3.generateJs());
            js.append(String.format(Locale.US, ".fill(%s, %f, %f, %s, %f, %f, %f)", arrayToString(keys2), cx, cy, ((mode3 != null) ? mode3.getJsBase() : "null"), opacity2, fx, fy));

            if (isRendered) {
                onChangeListener.onChange(String.format(Locale.US, ".fill(%s, %f, %f, %s, %f, %f, %f)", arrayToString(keys2), cx, cy, ((mode3 != null) ? mode3.getJsBase() : "null"), opacity2, fx, fy));
                js.setLength(0);
            }
        }
        return this;
    }


    /**
     * Radial gradient fill.
{docs:Graphics/Fill_Settings}Learn more about coloring.{docs}
     */
    public UiMarkersFactory fill(String[] keys3, Double cx, Double cy, GraphicsMathRect mode3, Double opacity2, Double fx, Double fy) {
        if (jsBase == null) {
            this.keys = null;
            this.keys1 = null;
            this.keys2 = null;
            this.keys3 = null;
            
            this.keys3 = keys3;
            this.cx = cx;
            this.cy = cy;
            this.mode = null;
            this.mode1 = null;
            this.mode2 = null;
            this.mode3 = null;
            
            this.mode3 = mode3;
            this.opacity = null;
            this.opacity1 = null;
            this.opacity2 = null;
            
            this.opacity2 = opacity2;
            this.fx = fx;
            this.fy = fy;
        } else {
            this.keys3 = keys3;
            this.cx = cx;
            this.cy = cy;
            this.mode3 = mode3;
            this.opacity2 = opacity2;
            this.fx = fx;
            this.fy = fy;
            if (!isChain) {
                js.append(jsBase);
                isChain = true;
            }
            js.append(mode3.generateJs());
            js.append(String.format(Locale.US, ".fill(%s, %f, %f, %s, %f, %f, %f)", arrayToStringWrapQuotes(keys3), cx, cy, ((mode3 != null) ? mode3.getJsBase() : "null"), opacity2, fx, fy));

            if (isRendered) {
                onChangeListener.onChange(String.format(Locale.US, ".fill(%s, %f, %f, %s, %f, %f, %f)", arrayToStringWrapQuotes(keys3), cx, cy, ((mode3 != null) ? mode3.getJsBase() : "null"), opacity2, fx, fy));
                js.setLength(0);
            }
        }
        return this;
    }

    private Fill imageSettings;
    private Double offsetX;
    private String offsetX1;

    /**
     * Setter for the offset by X of all markers.
     */
    public UiMarkersFactory setOffsetX(Double offsetX) {
        if (jsBase == null) {
            this.offsetX = null;
            this.offsetX1 = null;
            
            this.offsetX = offsetX;
        } else {
            this.offsetX = offsetX;
            if (!isChain) {
                js.append(jsBase);
                isChain = true;
            }
            
            js.append(String.format(Locale.US, ".offsetX(%f)", offsetX));

            if (isRendered) {
                onChangeListener.onChange(String.format(Locale.US, ".offsetX(%f)", offsetX));
                js.setLength(0);
            }
        }
        return this;
    }


    /**
     * Setter for the offset by X of all markers.
     */
    public UiMarkersFactory setOffsetX(String offsetX1) {
        if (jsBase == null) {
            this.offsetX = null;
            this.offsetX1 = null;
            
            this.offsetX1 = offsetX1;
        } else {
            this.offsetX1 = offsetX1;
            if (!isChain) {
                js.append(jsBase);
                isChain = true;
            }
            
            js.append(String.format(Locale.US, ".offsetX(%s)", wrapQuotes(offsetX1)));

            if (isRendered) {
                onChangeListener.onChange(String.format(Locale.US, ".offsetX(%s)", wrapQuotes(offsetX1)));
                js.setLength(0);
            }
        }
        return this;
    }

    private Double offsetY;
    private String offsetY1;

    /**
     * Setter for the offset by Y of all markers.
     */
    public UiMarkersFactory setOffsetY(Double offsetY) {
        if (jsBase == null) {
            this.offsetY = null;
            this.offsetY1 = null;
            
            this.offsetY = offsetY;
        } else {
            this.offsetY = offsetY;
            if (!isChain) {
                js.append(jsBase);
                isChain = true;
            }
            
            js.append(String.format(Locale.US, ".offsetY(%f)", offsetY));

            if (isRendered) {
                onChangeListener.onChange(String.format(Locale.US, ".offsetY(%f)", offsetY));
                js.setLength(0);
            }
        }
        return this;
    }


    /**
     * Setter for the offset by Y of all markers.
     */
    public UiMarkersFactory setOffsetY(String offsetY1) {
        if (jsBase == null) {
            this.offsetY = null;
            this.offsetY1 = null;
            
            this.offsetY1 = offsetY1;
        } else {
            this.offsetY1 = offsetY1;
            if (!isChain) {
                js.append(jsBase);
                isChain = true;
            }
            
            js.append(String.format(Locale.US, ".offsetY(%s)", wrapQuotes(offsetY1)));

            if (isRendered) {
                onChangeListener.onChange(String.format(Locale.US, ".offsetY(%s)", wrapQuotes(offsetY1)));
                js.setLength(0);
            }
        }
        return this;
    }

    private String position;

    /**
     * Setter for position settings of all markers.
     */
    public UiMarkersFactory setPosition(String position) {
        if (jsBase == null) {
            this.position = position;
        } else {
            this.position = position;
            if (!isChain) {
                js.append(jsBase);
                isChain = true;
            }
            
            js.append(String.format(Locale.US, ".position(%s)", wrapQuotes(position)));

            if (isRendered) {
                onChangeListener.onChange(String.format(Locale.US, ".position(%s)", wrapQuotes(position)));
                js.setLength(0);
            }
        }
        return this;
    }

    private Double rotation;

    /**
     * Setter for the rotation angle around an anchor.
({@link anychart.graphics.vector.Element}).
     */
    public UiMarkersFactory setRotation(Double rotation) {
        if (jsBase == null) {
            this.rotation = rotation;
        } else {
            this.rotation = rotation;
            if (!isChain) {
                js.append(jsBase);
                isChain = true;
            }
            
            js.append(String.format(Locale.US, ".rotation(%f)", rotation));

            if (isRendered) {
                onChangeListener.onChange(String.format(Locale.US, ".rotation(%f)", rotation));
                js.setLength(0);
            }
        }
        return this;
    }

    private Double size;

    /**
     * Setter for the size of all markers.
     */
    public UiMarkersFactory setSize(Double size) {
        if (jsBase == null) {
            this.size = size;
        } else {
            this.size = size;
            if (!isChain) {
                js.append(jsBase);
                isChain = true;
            }
            
            js.append(String.format(Locale.US, ".size(%f)", size));

            if (isRendered) {
                onChangeListener.onChange(String.format(Locale.US, ".size(%f)", size));
                js.setLength(0);
            }
        }
        return this;
    }

    private Stroke stroke;
    private String stroke1;

    /**
     * Setter for stroke settings of all markers.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs}
     */
    public UiMarkersFactory setStroke(Stroke stroke) {
        if (jsBase == null) {
            this.stroke = null;
            this.stroke1 = null;
            
            this.stroke = stroke;
        } else {
            this.stroke = stroke;
            if (!isChain) {
                js.append(jsBase);
                isChain = true;
            }
            
            js.append(String.format(Locale.US, ".stroke(%s)", ((stroke != null) ? stroke.generateJs() : "null")));

            if (isRendered) {
                onChangeListener.onChange(String.format(Locale.US, ".stroke(%s)", ((stroke != null) ? stroke.generateJs() : "null")));
                js.setLength(0);
            }
        }
        return this;
    }


    /**
     * Setter for stroke settings of all markers.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs}
     */
    public UiMarkersFactory setStroke(String stroke1) {
        if (jsBase == null) {
            this.stroke = null;
            this.stroke1 = null;
            
            this.stroke1 = stroke1;
        } else {
            this.stroke1 = stroke1;
            if (!isChain) {
                js.append(jsBase);
                isChain = true;
            }
            
            js.append(String.format(Locale.US, ".stroke(%s)", wrapQuotes(stroke1)));

            if (isRendered) {
                onChangeListener.onChange(String.format(Locale.US, ".stroke(%s)", wrapQuotes(stroke1)));
                js.setLength(0);
            }
        }
        return this;
    }

    private Stroke color1;
    private ColoredFill color2;
    private String color3;
    private Double thickness;
    private String dashpattern;
    private StrokeLineJoin lineJoin;
    private StrokeLineCap lineCap;

    /**
     * Setter for stroke settings of all markers.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs}
     */
    public UiMarkersFactory setStroke(Stroke color1, Double thickness, String dashpattern, StrokeLineJoin lineJoin, StrokeLineCap lineCap) {
        if (jsBase == null) {
            this.color = null;
            this.color1 = null;
            this.color2 = null;
            this.color3 = null;
            
            this.color1 = color1;
            this.thickness = thickness;
            this.dashpattern = dashpattern;
            this.lineJoin = lineJoin;
            this.lineCap = lineCap;
        } else {
            this.color1 = color1;
            this.thickness = thickness;
            this.dashpattern = dashpattern;
            this.lineJoin = lineJoin;
            this.lineCap = lineCap;
            if (!isChain) {
                js.append(jsBase);
                isChain = true;
            }
            
            js.append(String.format(Locale.US, ".stroke(%s, %f, %s, %s, %s)", ((color1 != null) ? color1.generateJs() : "null"), thickness, wrapQuotes(dashpattern), ((lineJoin != null) ? lineJoin.generateJs() : "null"), ((lineCap != null) ? lineCap.generateJs() : "null")));

            if (isRendered) {
                onChangeListener.onChange(String.format(Locale.US, ".stroke(%s, %f, %s, %s, %s)", ((color1 != null) ? color1.generateJs() : "null"), thickness, wrapQuotes(dashpattern), ((lineJoin != null) ? lineJoin.generateJs() : "null"), ((lineCap != null) ? lineCap.generateJs() : "null")));
                js.setLength(0);
            }
        }
        return this;
    }


    /**
     * Setter for stroke settings of all markers.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs}
     */
    public UiMarkersFactory setStroke(ColoredFill color2, Double thickness, String dashpattern, StrokeLineJoin lineJoin, StrokeLineCap lineCap) {
        if (jsBase == null) {
            this.color = null;
            this.color1 = null;
            this.color2 = null;
            this.color3 = null;
            
            this.color2 = color2;
            this.thickness = thickness;
            this.dashpattern = dashpattern;
            this.lineJoin = lineJoin;
            this.lineCap = lineCap;
        } else {
            this.color2 = color2;
            this.thickness = thickness;
            this.dashpattern = dashpattern;
            this.lineJoin = lineJoin;
            this.lineCap = lineCap;
            if (!isChain) {
                js.append(jsBase);
                isChain = true;
            }
            
            js.append(String.format(Locale.US, ".stroke(%s, %f, %s, %s, %s)", ((color2 != null) ? color2.generateJs() : "null"), thickness, wrapQuotes(dashpattern), ((lineJoin != null) ? lineJoin.generateJs() : "null"), ((lineCap != null) ? lineCap.generateJs() : "null")));

            if (isRendered) {
                onChangeListener.onChange(String.format(Locale.US, ".stroke(%s, %f, %s, %s, %s)", ((color2 != null) ? color2.generateJs() : "null"), thickness, wrapQuotes(dashpattern), ((lineJoin != null) ? lineJoin.generateJs() : "null"), ((lineCap != null) ? lineCap.generateJs() : "null")));
                js.setLength(0);
            }
        }
        return this;
    }


    /**
     * Setter for stroke settings of all markers.
{docs:Graphics/Stroke_Settings}Learn more about stroke settings.{docs}
     */
    public UiMarkersFactory setStroke(String color3, Double thickness, String dashpattern, StrokeLineJoin lineJoin, StrokeLineCap lineCap) {
        if (jsBase == null) {
            this.color = null;
            this.color1 = null;
            this.color2 = null;
            this.color3 = null;
            
            this.color3 = color3;
            this.thickness = thickness;
            this.dashpattern = dashpattern;
            this.lineJoin = lineJoin;
            this.lineCap = lineCap;
        } else {
            this.color3 = color3;
            this.thickness = thickness;
            this.dashpattern = dashpattern;
            this.lineJoin = lineJoin;
            this.lineCap = lineCap;
            if (!isChain) {
                js.append(jsBase);
                isChain = true;
            }
            
            js.append(String.format(Locale.US, ".stroke(%s, %f, %s, %s, %s)", wrapQuotes(color3), thickness, wrapQuotes(dashpattern), ((lineJoin != null) ? lineJoin.generateJs() : "null"), ((lineCap != null) ? lineCap.generateJs() : "null")));

            if (isRendered) {
                onChangeListener.onChange(String.format(Locale.US, ".stroke(%s, %f, %s, %s, %s)", wrapQuotes(color3), thickness, wrapQuotes(dashpattern), ((lineJoin != null) ? lineJoin.generateJs() : "null"), ((lineCap != null) ? lineCap.generateJs() : "null")));
                js.setLength(0);
            }
        }
        return this;
    }

    private MarkerType type;
    private String type1;

    /**
     * Setter for type settings of all markers.
     */
    public UiMarkersFactory setType(MarkerType type) {
        if (jsBase == null) {
            this.type = null;
            this.type1 = null;
            
            this.type = type;
        } else {
            this.type = type;
            if (!isChain) {
                js.append(jsBase);
                isChain = true;
            }
            
            js.append(String.format(Locale.US, ".type(%s)", ((type != null) ? type.generateJs() : "null")));

            if (isRendered) {
                onChangeListener.onChange(String.format(Locale.US, ".type(%s)", ((type != null) ? type.generateJs() : "null")));
                js.setLength(0);
            }
        }
        return this;
    }


    /**
     * Setter for type settings of all markers.
     */
    public UiMarkersFactory setType(String type1) {
        if (jsBase == null) {
            this.type = null;
            this.type1 = null;
            
            this.type1 = type1;
        } else {
            this.type1 = type1;
            if (!isChain) {
                js.append(jsBase);
                isChain = true;
            }
            
            js.append(String.format(Locale.US, ".type(%s)", wrapQuotes(type1)));

            if (isRendered) {
                onChangeListener.onChange(String.format(Locale.US, ".type(%s)", wrapQuotes(type1)));
                js.setLength(0);
            }
        }
        return this;
    }


    protected String generateJsGetters() {
        StringBuilder jsGetters = new StringBuilder();

        jsGetters.append(super.generateJsGetters());

    

        return jsGetters.toString();
    }

    @Override
    protected String generateJs() {
        if (isChain) {
            js.append(";");
            isChain = false;
        }

        js.append(generateJsGetters());

        

        String result = js.toString();
        js.setLength(0);
        return result;
    }

}