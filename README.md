# Component Integration Demo App

This demo project showcases different ways to integrate various types of HTML elements and web components into a Vaadin Flow application. It covers native HTML elements, custom Web Components, React components, and plain JavaScript-based elements. An example with widget has not been considered.

## 🔧 Getting Started

1. Open the project in your IDE (e.g., IntelliJ).
2. Locate the `Application.java` class.
3. Run the main method using “Debug”.
4. (Optional) Install the Vaadin IntelliJ plugin and use “Debug with HotswapAgent” for instant Java updates in the browser.

---

## 📦 What This Project Demonstrates

### ✅ Potential Elements in a Web Application

| Type                  | Description                                                                 |
|-----------------------|-----------------------------------------------------------------------------|
| **HTML Native Elements**  | Built-in elements like `<button>`, `<canvas>`, `<select>`                |
| **Custom Web Components** | Shadow DOM–based, framework-independent, reusable                         |
| **Embedded Widgets**      | External iframes/scripts (e.g., YouTube, chat)                            |
| **Framework Components**  | React/Vue/Angular—framework-specific, rendered via adapter                |
| **Vaadin Components**     | Java-backed components, built on Web Component standard                   |

---

## 📂 Integration Examples in This App

### 1. **HTML Native Elements**

Implemented via Vaadin’s `Element` API. Example: add native html components such as `<input>` and `<button>` as well as drawing on a `<canvas>` and listening to JS events.

➡️ `NativeHtmlView.java`

---

### 2. **Vanilla JS Integration (via Element API)**

JS component initialized with `window.init(this)` and controlled via `callJsFunction`.

#### 🔄 Connector vs. Web Component Approach

| Feature                        | JS Connector (`SpinWheelWrapper`) | Web Component (`SpinWheelComponent`) |
|--------------------------------|-----------------------------------|--------------------------------------|
| Uses `<script>` init           | ✅                                | ❌                                   |
| Uses `<custom-element>` tag    | ❌                                | ✅                                   |
| Encapsulation (Shadow DOM)     | ❌                                | ✅                                   |
| Reusability outside Vaadin     | ❌                                | ✅                                   |
| Works well for quick demo      | ✅                                | ⚠️                                   |
| Preferred for production       | ❌                                | ✅                                   |

➡️ `SpinWheelWrapper.java` and `spin-wheel-wrapper.js` (Java Script initialized component)

➡️ `SpinWheelComponent.java` and `spin-wheel-component.js` (Integration as WebComponent)

➡️ `VanillaJsView.java`

---

### 3. **Embedded Widget**

E.g. `<model-viewer>` to embed 3D models using a third-party Web Component. Installed via npm and used like a regular Vaadin component.

➡️ `ModelViewer.java` and `WebComponentView.java`

---

### 4. **React Component**

Using the `ReactAdapterElement` (in React) and `ReactAdapterComponent` (in Java) API (Vaadin 24.4+). Example with `rc-slider`.

➡️ `ReactSlider.java`, `react-slider.tsx`, and `ReactComponentView.java`

---

## 📚 Resources

- [Vaadin Web Component Integration Guide](https://vaadin.com/docs/latest/flow/create-ui/web-components)
- [Vaadin React Integration](https://vaadin.com/docs/latest/flow/integrations/react)
- [model-viewer by Google](https://modelviewer.dev/)
- [Start a Vaadin project](https://start.vaadin.com/)

---

Explore the code, run the examples, and use the approach that fits your needs!
