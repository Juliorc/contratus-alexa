import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

class ShareContract extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; padding-left: 30px">
 <vaadin-form-layout>
  <h1>Compartir Contrato</h1>
 </vaadin-form-layout>
 <vaadin-horizontal-layout theme="spacing" style="width: 100%; alignment: center; align-self: center; align-items: center; justify-content: center; margin-top: 50px" id="vaadinHorizontalLayout">
  <a href="https://www.facebook.com/"><img src="frontend/images/facebook.png" alt="Facebook" id="FacebookImg" style="width:100px;height:100px; padding-left: 30px"></a>
  <a href="https://www.twitter.com/"><img src="frontend/images/twitter.png" alt="Twitter" id="TwitterImg" style="width:100px;height:100px; padding-left: 30px"></a>
  <a href="https://www.instagram.com/"><img src="frontend/images/instagram.png" alt="Instagram" id="InstagramImg" style="width:100px;height:100px; padding-left: 30px"></a>
  <a href="https://web.whatsapp.com/"><img src="frontend/images/whatsapp.png" alt="WhatsApp" id="WhatsAppImg" style="width:100px;height:100px; padding-left: 30px"></a>
  <a href="http://localhost:8080/login"><img src="frontend/images/copiar.png" alt="Copiar" id="CopiarImg" style="width:100px;height:100px; padding-left: 30px"></a>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'share-contract';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(ShareContract.is, ShareContract);
