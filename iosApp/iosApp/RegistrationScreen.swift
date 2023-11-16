//
//  RegistrationScreen.swift
//  iosApp
//
//  Created by Данила Еремин on 16.11.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct RegistrationScreen: View {
    @State var fio: String = ""
    let interactor: LoginDataInteractor = DocumentsApp().dialogChatModuleNew.loginDataInteractor
    var body: some View {
        ScrollView{
            VStack{
                Image("Image")
                Text("Регистрация")
                    .font(.title)
                HStack{
                    TextField("ФИО",text: $fio)
                        .padding(10)
                }
                .background(Color.white)
                .clipShape(RoundedRectangle(cornerRadius: 8, style: .continuous))
                .padding(.horizontal, 16)
                
                HStack{
                    TextField("Дата рождения",text: $fio)
                        .padding(10)
                }
                .background(Color.white)
                .clipShape(RoundedRectangle(cornerRadius: 8, style: .continuous))
                .padding(.horizontal, 16)
                
                HStack{
                    TextField("Логин",text: $fio)
                        .padding(10)
                }
                .background(Color.white)
                .clipShape(RoundedRectangle(cornerRadius: 8, style: .continuous))
                .padding(.horizontal, 16)
                
                HStack{
                    TextField("Пароль",text: $fio)
                        .padding(10)
                }
                .background(Color.white)
                .clipShape(RoundedRectangle(cornerRadius: 8, style: .continuous))
                .padding(.horizontal, 16)
                
                HStack{
                    TextField("Повторите пароль",text: $fio)
                        .padding(10)
                }
                .background(Color.white)
                .clipShape(RoundedRectangle(cornerRadius: 8, style: .continuous))
                .padding(.horizontal, 16)
                
               
                Spacer(minLength: 40)
                
                HStack{
                    Text("Зарегистрироваться")
                        .padding(.horizontal, 30)
                        .padding(.vertical, 10)
                }
                
                .background(Color.white)
                .clipShape(RoundedRectangle(cornerRadius: 8, style: .continuous))
                .padding(.horizontal, 16)
                .onTapGesture {
                    interactor.registration(fio: fio)
                }
            
            }
        }
    
        .background(Color("main"))
        .frame(width: .infinity, height: .infinity)
        
    }
}

#Preview {
    RegistrationScreen()
}
