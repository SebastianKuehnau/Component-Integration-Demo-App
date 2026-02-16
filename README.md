# Component Integration Demo App

A Vaadin reference application that shows how to use built-in components, create custom elements, and integrate third-party JavaScript, React, and Web Components into a [Vaadin Flow](https://vaadin.com/flow) application.

**Tech Stack:** Java 21, Spring Boot 4.0.2, Vaadin 25.0.4, React 19, TypeScript 5.9

## Getting Started

```bash
# Run in development mode (hot reload enabled)
./mvnw

# Production build
./mvnw clean package

# Run production JAR
java -jar target/component-integration-demo-app-1.0-SNAPSHOT.jar
```

The app starts at **http://localhost:8080**.

For the best development experience, use IntelliJ with the [Vaadin plugin](https://plugins.jetbrains.com/plugin/23765-vaadin) and "Debug with HotswapAgent" for instant Java updates in the browser.

---

## App Structure

The app has four views, accessible via the side navigation:

| # | View | Route | What it shows |
|---|------|-------|---------------|
| 1 | [Simple View](#1-simple-view) | `/` | Vaadin components, Elements API, Addon Directory |
| 2 | [Custom Component View](#2-custom-component-view) | `/custom-component` | A small Custom Element with bidirectional Java/JS communication |
| 3 | [Integration View](#3-integration-view) | `/integration-demo` | Three slider integrations side-by-side: Vanilla JS, React, Web Component |
| 4 | [Misc Components View](#4-misc-components-view) | `/demo` | Additional examples in a tabbed layout |

---

## 1. Simple View

**Route:** `/` (alias: `/simple-demo`)
**File:** [`SimpleView.java`](src/main/java/org/vaadin/demo/views/demo/SimpleView.java)

Shows three ways to build UIs in Vaadin without any custom frontend code:

- **Vaadin Components** — `TextField`, `Button`, `ComboBox` used directly in Java
- **Native HTML via Elements API** — `<input>`, `<button>`, `<select>` created with `new Element("select")` and event listeners attached on the server
- **Addon Directory** — Link to [vaadin.com/directory](https://vaadin.com/directory) for ready-made community components

**Relevant docs:**
- [Vaadin Components](https://vaadin.com/docs/latest/components)
- [Standard HTML Elements](https://vaadin.com/docs/latest/components/html-elements)
- [Addon Directory](https://vaadin.com/directory)

---

## 2. Custom Component View

**Route:** `/custom-component`
**File:** [`CustomComponentView.java`](src/main/java/org/vaadin/demo/views/demo/CustomComponentView.java)

A small example of creating a custom element from scratch with bidirectional communication:

| File | Role |
|------|------|
| [`MyCustomElement.java`](src/main/java/org/vaadin/demo/components/custom/MyCustomElement.java) | Java wrapper — `@JsModule` + `@Tag` |
| [`my-custom-element.js`](src/main/frontend/components/custom/my-custom-element.js) | Vanilla JS custom element |

**Communication patterns used:**
- **Java -> JS:** `getElement().callJsFunction("setText", text)`
- **JS -> Java:** `dispatchEvent(new CustomEvent("text-submitted"))` + `@DomEvent` on the Java side

**Relevant docs:**
- [Creating a Web Component](https://vaadin.com/docs/latest/flow/create-ui/web-components)

---

## 3. Integration View

**Route:** `/integration-demo`
**File:** [`IntegrationView.java`](src/main/java/org/vaadin/demo/views/demo/IntegrationView.java)

The main showcase: three slider components built with three different integration approaches, shown side-by-side for comparison.

### Vanilla JS — NoUiSlider

Wraps the [nouislider](https://www.npmjs.com/package/nouislider) npm library as a custom element.

| File | Role |
|------|------|
| [`NoUiSlider.java`](src/main/java/org/vaadin/demo/components/vanilla/NoUiSlider.java) | Java wrapper — `@NpmPackage` + `@JsModule` + `@Tag` |
| [`nouislider-element.js`](src/main/frontend/components/vanilla/nouislider-element.js) | Custom element wrapping the library |

**Key pattern:** Property getters/setters in JS, `setProperty()`/`getProperty()` in Java, custom DOM events for value changes.

### React — rc-slider

Integrates the [rc-slider](https://www.npmjs.com/package/rc-slider) React component using Vaadin's `ReactAdapterComponent`.

| File | Role |
|------|------|
| [`RcSlider.java`](src/main/java/org/vaadin/demo/components/react/RcSlider.java) | Java wrapper — extends `ReactAdapterComponent` |
| [`rc-slider.tsx`](src/main/frontend/components/react/rc-slider.tsx) | TSX adapter — extends `ReactAdapterElement` |

**Key pattern:** `setState()`/`getState()` in Java, `hooks.useState()` in TSX, `addStateChangeListener()` for value changes.

### Web Component — Shoelace Range

Uses the [`<sl-range>`](https://shoelace.style/components/range) component from [Shoelace](https://shoelace.style/) — no custom JS needed.

| File | Role |
|------|------|
| [`ShoelaceRange.java`](src/main/java/org/vaadin/demo/components/webcomponents/ShoelaceRange.java) | Java wrapper — `@NpmPackage` + `@Tag("sl-range")` |

**Key pattern:** Extends `AbstractSinglePropertyField` for automatic value sync, `PropertyDescriptors` for attributes, `@DomEvent` for events.

**Relevant docs:**
- [Integrating a JS Library (Vanilla)](https://vaadin.com/docs/latest/flow/create-ui/web-components)
- [React Integration](https://vaadin.com/docs/latest/flow/integrations/react)
- [Using npm Web Components](https://vaadin.com/docs/latest/flow/create-ui/web-components)

---

## 4. Misc Components View

**Route:** `/demo`
**File:** [`MiscComponentsView.java`](src/main/java/org/vaadin/demo/views/misc/MiscComponentsView.java)

A tabbed layout with additional integration examples:

| Tab | What it shows | Key files |
|-----|---------------|-----------|
| **Native HTML** | Canvas drawing via `executeJs()` | [`Tab1NativeHTML.java`](src/main/java/org/vaadin/demo/views/misc/tabs/Tab1NativeHTML.java) |
| **JS Component** | Star Rating custom element | [`Tab2JsComponent.java`](src/main/java/org/vaadin/demo/views/misc/tabs/Tab2JsComponent.java), [`StarRatingComponent.java`](src/main/java/org/vaadin/demo/views/misc/components/StarRatingComponent.java), [`star-rating.js`](src/main/frontend/components/misc/star-rating.js) |
| **React Component (Switch)** | MUI Switch via ReactAdapter | [`Tab3ReactComponent.java`](src/main/java/org/vaadin/demo/views/misc/tabs/Tab3ReactComponent.java), [`SwitchComponent.java`](src/main/java/org/vaadin/demo/views/misc/components/SwitchComponent.java), [`react-switch.tsx`](src/main/frontend/components/misc/react-switch.tsx) |
| **Web Component** | emoji-picker-element (npm) | [`Tab4WebComponent.java`](src/main/java/org/vaadin/demo/views/misc/tabs/Tab4WebComponent.java), [`EmojiComponent.java`](src/main/java/org/vaadin/demo/views/misc/components/EmojiComponent.java) |
| **React Playground** | react-spin-wheel | [`Tab5ReactPlayground.java`](src/main/java/org/vaadin/demo/views/misc/tabs/Tab5ReactPlayground.java), [`SpinWheelComponent.java`](src/main/java/org/vaadin/demo/views/misc/components/SpinWheelComponent.java), [`react-spin-wheel.tsx`](src/main/frontend/components/misc/react-spin-wheel.tsx) |
| **Extended JS Component** | FeedbackForm with `@ClientCallable` | [`Tab6ExtJsComponent.java`](src/main/java/org/vaadin/demo/views/misc/tabs/Tab6ExtJsComponent.java), [`FeedbackForm.java`](src/main/java/org/vaadin/demo/views/misc/components/FeedbackForm.java), [`feedback-form.js`](src/main/frontend/components/misc/feedback-form.js) |

---

## Project Layout

```
src/main/java/org/vaadin/demo/
  views/
    MainLayout.java                     # AppLayout with side navigation
    demo/
      SimpleView.java                   # Vaadin components + Elements API
      CustomComponentView.java          # Custom Element demo
      IntegrationView.java             # 3 sliders side-by-side
    misc/
      MiscComponentsView.java          # Tabbed misc examples
      tabs/                             # One class per tab
      components/                       # Misc component wrappers
  components/
    custom/    MyCustomElement.java      # Custom element wrapper
    vanilla/   NoUiSlider.java          # Vanilla JS library wrapper
    react/     RcSlider.java            # React component wrapper
    webcomponents/ ShoelaceRange.java   # Third-party Web Component wrapper

src/main/frontend/components/
  custom/    my-custom-element.js
  vanilla/   nouislider-element.js
  react/     rc-slider.tsx
  misc/      star-rating.js, feedback-form.js, hello-world.js,
             react-switch.tsx, react-spin-wheel.tsx
```

---

## Java/JS Communication Cheat Sheet

| Direction | Method | Example |
|-----------|--------|---------|
| **Java -> JS (property)** | `getElement().setProperty("value", 42)` | NoUiSlider |
| **Java -> JS (function call)** | `getElement().callJsFunction("setText", text)` | MyCustomElement |
| **Java -> JS (React state)** | `setState("sliderValue", 50)` | RcSlider |
| **JS -> Java (DOM event)** | `dispatchEvent(new CustomEvent(...))` + `@DomEvent` | StarRating, NoUiSlider |
| **JS -> Java (RPC)** | `this.$server.getGreeting(name)` + `@ClientCallable` | FeedbackForm |
| **JS -> Java (React state)** | `hooks.useState()` + `addStateChangeListener()` | RcSlider |

---

## Resources

- [Vaadin Documentation](https://vaadin.com/docs)
- [Vaadin Components](https://vaadin.com/docs/latest/components)
- [Web Component Integration](https://vaadin.com/docs/latest/flow/create-ui/web-components)
- [React Integration](https://vaadin.com/docs/latest/flow/integrations/react)
- [Vaadin Addon Directory](https://vaadin.com/directory)
- [Start a Vaadin Project](https://start.vaadin.com/)
- [nouislider](https://www.npmjs.com/package/nouislider) | [rc-slider](https://www.npmjs.com/package/rc-slider) | [Shoelace](https://shoelace.style/)
- [model-viewer by Google](https://modelviewer.dev/)