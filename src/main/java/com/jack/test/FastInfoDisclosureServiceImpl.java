//package com.manager.service.impl;
//
//import com.google.common.collect.Lists;
//import com.manager.bo.fastdisclosure.FastDisclosureBuilder;
//import com.manager.dto.fastinfodisclosure.req.CommunicateTrusteeshipSaveReq;
//import com.manager.dto.fastinfodisclosure.req.ConfirmApplyReq;
//import com.manager.dto.fastinfodisclosure.rsp.CommunicateTrusteeshipListRsp;
//import com.manager.dto.fastinfodisclosure.rsp.DataFromMiddle;
//import com.manager.dto.fastinfodisclosure.rsp.FastInfoDisclosureListRsp;
//import com.manager.dto.fastinfodisclosure.rsp.ListTrusteeshipRsp;
//import com.manager.entity.FastDisclosure;
//import com.manager.entity.Product;
//import com.manager.enums.FastInfoDisclosureEnum;
//import com.manager.enums.YesOrNoEnum;
//import com.manager.handler.service.IFastDisclosureService;
//import com.manager.handler.service.IProductService;
//import com.manager.service.FastInfoDisclosureRpcService;
//import com.manager.util.GitUidUtils;
//import com.manager.util.LoginUserUtil;
//import com.manager.utils.ModelUtils;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.collections4.CollectionUtils;
//import org.apache.commons.lang3.math.NumberUtils;
//import org.apache.dubbo.config.annotation.DubboService;
//import org.springframework.stereotype.Component;
//
//
//import javax.annotation.Resource;
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//
//
//@DubboService
//@Component
//@Slf4j
//public class FastInfoDisclosureServiceImpl implements FastInfoDisclosureRpcService {
//
//    @Resource
//    private IProductService iProductService;
//    @Resource
//    private IFastDisclosureService iFastDisclosureService;
//
//    @Override
//    public List<FastInfoDisclosureListRsp> listInfo() {
//        List<FastInfoDisclosureListRsp> list = Lists.newArrayList();
//        Long companyCode = LoginUserUtil.getCompanyCode();
//
//        FastInfoDisclosureListRsp reminderOfTrusteeshipRsp = FastInfoDisclosureListRsp.builder()
//                .content(FastInfoDisclosureEnum.TRUSTEESHIP.getCodeText())
//                .reminderType(FastInfoDisclosureEnum.TRUSTEESHIP.getCodeValue())
//                .build();
//        FastInfoDisclosureListRsp reminderOfProductRsp = FastInfoDisclosureListRsp.builder()
//                .content(FastInfoDisclosureEnum.PRODUCT.getCodeText())
//                .reminderType(FastInfoDisclosureEnum.PRODUCT.getCodeValue())
//                .build();
//
//        // 数据库中记录的提示数据
//        Map<Integer, FastDisclosure> fastDisclosuresMap = ModelUtils.convertToMap(iFastDisclosureService.listByCompanyCode(companyCode), FastDisclosure::getReminderType);
//
//        // 从中台获取到数据
//        DataFromMiddle dataFromMiddle = getDataFromMiddle(companyCode);
//
//        // 基金页协会所有托管
//        Long trusteeshipsFromAssociationNum = dataFromMiddle.getTrusteeshipsFromAssociationNum();
//        // 我司中台打通的托管
//        Long existTrusteeshipsNum = dataFromMiddle.getExistTrusteeshipsNum();
//        // 从中台拉取到管理人的产品数量
//        Long productsFromAssociationNum = dataFromMiddle.getProductsFromAssociationNum();
//
//        // 记录的对接托管提示
//        FastDisclosure reminderOfTrusteeship = fastDisclosuresMap.get(FastInfoDisclosureEnum.TRUSTEESHIP.getCodeValue());
//        if (reminderOfTrusteeship == null) {
//            // 数据库种提示信息未存在,直接提示
//            if (existTrusteeshipsNum != null && trusteeshipsFromAssociationNum != null && existTrusteeshipsNum < trusteeshipsFromAssociationNum) {
//                // 已对接的托管小于基金页协会所有托管，则需要提示对接托管
//                list.add(reminderOfTrusteeshipRsp);
//                Long fastDisclosureId = GitUidUtils.getUid();
//                reminderOfTrusteeshipRsp.setFastDisclosureId(fastDisclosureId);
//                FastDisclosure entity = FastDisclosureBuilder.build4Create(fastDisclosureId, companyCode, trusteeshipsFromAssociationNum, existTrusteeshipsNum,
//                        productsFromAssociationNum, FastInfoDisclosureEnum.TRUSTEESHIP.getCodeValue(), YesOrNoEnum.NO.getCodeValue());
//                iFastDisclosureService.save(entity);
//            }
//        } else {
//            reminderOfTrusteeshipRsp.setFastDisclosureId(reminderOfTrusteeship.getFastDisclosureId());
//            // 数据库中提示信息已存在
//            if (Objects.equals(YesOrNoEnum.NO.getCodeValue(), reminderOfTrusteeship.getIsClicked())) {
//                // 判断这条提示是否已点击过,如果未点击过，且获取到的最新信息是需要提示的，则需要提示
//                if (existTrusteeshipsNum != null && trusteeshipsFromAssociationNum != null && existTrusteeshipsNum < trusteeshipsFromAssociationNum) {
//                    list.add(reminderOfTrusteeshipRsp);
//                }
//            } else {
//                // 如果点击过，则需要去比对这次从中台获取的数据相比数据库保存的数据是否有变化,如果基金页协会所有托管更多了，则需要提示
//                if (reminderOfTrusteeship.getTrusteeshipsFromAssociation() != null && trusteeshipsFromAssociationNum > reminderOfTrusteeship.getTrusteeshipsFromAssociation()) {
//                    // 总共有10个，有8个未维护，如果总的10个不变化的话，即使没有全维护，也不提示
//                    list.add(reminderOfTrusteeshipRsp);
//                }
//            }
//            // 比对从中台获取的数据与当前记录的是否一样，如不一样，则需要更新
//            compareAndUpdate(trusteeshipsFromAssociationNum, existTrusteeshipsNum, productsFromAssociationNum, reminderOfTrusteeship);
//        }
//
//
//        List<Product> products = iProductService.listByCompanyCode(companyCode);
//        // 系统中的产品数量
//        int size = CollectionUtils.isEmpty(products) ? NumberUtils.INTEGER_ZERO : products.size();
//
//
//        FastDisclosure reminderOfProduct = fastDisclosuresMap.get(FastInfoDisclosureEnum.PRODUCT.getCodeValue());
//        if (reminderOfProduct == null) {
//            // 数据库种提示信息未存在,直接提示
//            if (productsFromAssociationNum != null && size < productsFromAssociationNum) {
//                // 系统中的产品数量小于中台拉取到管理人的产品数量
//                list.add(reminderOfProductRsp);
//                Long fastDisclosureId = GitUidUtils.getUid();
//                reminderOfProductRsp.setFastDisclosureId(fastDisclosureId);
//                FastDisclosure entity = FastDisclosureBuilder.build4Create(fastDisclosureId, companyCode, trusteeshipsFromAssociationNum, existTrusteeshipsNum,
//                        productsFromAssociationNum, FastInfoDisclosureEnum.PRODUCT.getCodeValue(), YesOrNoEnum.NO.getCodeValue());
//                iFastDisclosureService.save(entity);
//            }
//
//        } else {
//            // 已存在，判断是否已点击过
//            reminderOfProductRsp.setFastDisclosureId(reminderOfProduct.getFastDisclosureId());
//            if (Objects.equals(YesOrNoEnum.NO.getCodeValue(), reminderOfProduct.getIsClicked())) {
//                // 未点击过，需要提示
//                if (productsFromAssociationNum != null && size < productsFromAssociationNum) {
//                    list.add(reminderOfProductRsp);
//                }
//            }
//            compareAndUpdate(trusteeshipsFromAssociationNum, existTrusteeshipsNum, productsFromAssociationNum, reminderOfProduct);
//        }
//
//        return list;
//    }
//
//    private void compareAndUpdate(Long trusteeshipsFromAssociationNum, Long existTrusteeshipsNum, Long productsFromAssociationNum, FastDisclosure fastDisclosure) {
//        if (fastDisclosure != null) {
//            if (!Objects.equals(fastDisclosure.getTrusteeshipsFromAssociation(), trusteeshipsFromAssociationNum)
//                    || !Objects.equals(fastDisclosure.getExistTrusteeships(), existTrusteeshipsNum)
//                    || !Objects.equals(fastDisclosure.getProductsFromAssociation(), productsFromAssociationNum)) {
//                fastDisclosure.setTrusteeshipsFromAssociation(trusteeshipsFromAssociationNum);
//                fastDisclosure.setExistTrusteeships(existTrusteeshipsNum);
//                fastDisclosure.setProductsFromAssociation(productsFromAssociationNum);
//                iFastDisclosureService.updateById(fastDisclosure);
//            }
//        }
//    }
//
//    private DataFromMiddle getDataFromMiddle(Long companyCode) {
//        return DataFromMiddle.builder()
//                .trusteeshipsFromAssociationNum(100L)
//                .existTrusteeshipsNum(10L)
//                .productsFromAssociationNum(10000L)
//                .build();
//    }
//
//    @Override
//    public List<CommunicateTrusteeshipListRsp> listCommunicateTrusteeship() {
//        return null;
//    }
//
//    @Override
//    public void confirmApply(ConfirmApplyReq req) {
//
//    }
//
//    @Override
//    public void saveTrusteeship(CommunicateTrusteeshipSaveReq req) {
//
//    }
//
//    @Override
//    public List<ListTrusteeshipRsp> listTrusteeship() {
//        return null;
//    }
//}
