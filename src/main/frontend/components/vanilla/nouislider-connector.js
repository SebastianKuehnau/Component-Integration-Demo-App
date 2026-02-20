// JS Connector approach: imports the npm library and exposes its factory on window.
// Java's executeJs() in NoUiSliderJS.onAttach() calls window._createSlider() to set up the slider.
// This keeps the connector minimal — all config logic stays in Java.
import noUiSlider from 'nouislider';
import 'nouislider/dist/nouislider.css';

window._createSlider = noUiSlider.create;
