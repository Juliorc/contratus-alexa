import { PolymerElement } from '@polymer/polymer/polymer-element.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-icons/vaadin-icons.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-layout.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-item.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';
import '@vaadin/vaadin-date-picker/src/vaadin-date-picker.js';
import '../../components/buttons-bar.js';
import '../../components/utils-mixin.js';
import './order-item-editor.js';
import '../../../styles/shared-styles.js';
import { html } from '@polymer/polymer/lib/utils/html-tag.js';

class OrderEditor extends window.ScrollShadowMixin(PolymerElement) {
  static get template() {
    return html`
<style include="shared-styles">
      :host {
        display: flex;
        flex-direction: column;
        flex: auto;
      }

      .meta-row {
        display: flex;
        justify-content: space-between;
        padding-bottom: var(--lumo-space-s);
      }

      .dim {
        color: var(--lumo-secondary-text-color);
        text-align: right;
        white-space: nowrap;
        line-height: 2.5em;
      }

      .status {
        width: 10em;
      }
    </style>
<div class="scrollable flex1" id="main" style="max-width: 1100px; margin: 0 auto;">
 <h2 id="title" style="text-align: center;">Nuevo Contrato</h2>
 <div class="meta-row" id="metaContainer" style="justify-content: space-around;">
  <vaadin-combo-box class="status" id="status"></vaadin-combo-box>
  <span class="dim">Contrato #<span id="orderNumber"></span></span>
 </div>
 <vaadin-form-layout id="form1" style="margin: 0 auto;">
  <vaadin-form-layout id="form3" colspan="4" style="margin: 0 auto;">
   <vaadin-form-layout id="form2">
    <vaadin-date-picker label="Fecha Inicio" id="startDate"></vaadin-date-picker>
   </vaadin-form-layout>
   <vaadin-form-layout id="form2">
    <vaadin-date-picker label="Fecha Final" id="dueDate" style="width: 100%;"></vaadin-date-picker>
   </vaadin-form-layout>
   <vaadin-text-field id="customerName" label="Cliente" colspan="2">
    <iron-icon slot="prefix" icon="vaadin:user"></iron-icon>
   </vaadin-text-field>
   <vaadin-text-field id="customerNumber" label="Numero de telefono">
    <iron-icon slot="prefix" icon="vaadin:phone"></iron-icon>
   </vaadin-text-field>
   <vaadin-text-field id="customerDetails" label="Descripcion" colspan="2"></vaadin-text-field>
   <vaadin-form-item colspan="3">
    <label slot="label">Productos o servicios</label>
   </vaadin-form-item>
   <div id="itemsContainer" colspan="3"></div>
  </vaadin-form-layout>
 </vaadin-form-layout>
</div>
<buttons-bar id="footer" no-scroll\$="[[noScroll]]" style="max-width: 1100px; margin: 0 auto; width: 100%;">
 <vaadin-button slot="left" id="cancel">
   Cancelar 
 </vaadin-button>
 <div slot="info" class="total">
   Total [[totalPrice]] 
 </div>
 <vaadin-button slot="right" id="review" theme="primary">
   Confirmar datos 
  <iron-icon icon="vaadin:arrow-right" slot="suffix"></iron-icon>
 </vaadin-button>
</buttons-bar>
`;
  }

  static get is() {
    return 'order-editor';
  }

  static get properties() {
    return {
      status: {
        type: String,
        observer: '_onStatusChange'
      }
    };
  }

  ready() {
    super.ready();

    // Not using attributes since Designer does not suppor single-quote attributes
    this.$.form1.responsiveSteps = [
      {columns: 1, labelsPosition: 'top'},
      {minWidth: '600px', columns: 4, labelsPosition: 'top'}
    ];
    this.$.form2.responsiveSteps = [
      {columns: 1, labelsPosition: 'top'},
      {minWidth: '360px', columns: 2, labelsPosition: 'top'}
    ];
    this.$.form3.responsiveSteps = [
      {columns: 1, labelsPosition: 'top'},
      {minWidth: '500px', columns: 3, labelsPosition: 'top'}
    ];
  }

  _onStatusChange() {
    const status = this.status ? this.status.toLowerCase() : this.status;
    this.$.status.$.input.setAttribute('status', status);
  }
}

console.log('aquiiiii');
window.customElements.define(OrderEditor.is, OrderEditor);
